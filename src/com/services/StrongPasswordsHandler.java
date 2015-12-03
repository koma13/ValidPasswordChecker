package com.services;

import com.comparator.UserComparator;
import com.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongPasswordsHandler extends Thread {
    private User user;
    private File file;
    public static final List<User> deserializeStrongPasswordUsers = new ArrayList<>();

    public StrongPasswordsHandler(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        file = Serializer.serializeUserToTempFile(user);
        synchronized (deserializeStrongPasswordUsers) {
            deserializeStrongPasswordUsers.add(Serializer.deserializeFileContentToObjects(file));
        }
    }

    public static void strongPasswordsUsersSortedSysout() {
        Collections.sort(deserializeStrongPasswordUsers, new UserComparator());
        UserPrinter.printMessage();
        UserPrinter.printOut(deserializeStrongPasswordUsers);

    }

    public static void processStrongPasswordUser(User user) throws InterruptedException {
        StrongPasswordsHandler strongPasswordsHandler = new StrongPasswordsHandler(user);
        strongPasswordsHandler.start();
        strongPasswordsHandler.join();
    }
}
