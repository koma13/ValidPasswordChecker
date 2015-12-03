package com.services;

import com.model.User;
import com.setup.FilesInitializer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class WeekPasswordsHandler extends Thread {
     private User user;
    public static Map<String, String> invalidPasswordUsersInMap = new LinkedHashMap<>();

    public WeekPasswordsHandler(User user) {
        this.user = user;
    }

    public synchronized void writeInFileWeekPassword() {
        try (BufferedWriter oWriter = new BufferedWriter(new FileWriter(FilesInitializer.WEEK_PASSWORD_USERS_TXT, true))) {
            oWriter.write(user.getPassword());
            oWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        writeInFileWeekPassword();
    }

    public static void processWeekPasswordUser(User user) {
        invalidPasswordUsersInMap.put(user.getLogin(), user.getPassword());
        new WeekPasswordsHandler(user).start();
        UserPrinter.printError(user);
    }

}

