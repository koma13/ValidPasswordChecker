package com.services;

import com.setup.FilesInitializer;
import com.model.User;

import java.io.*;

public class WeekPasswordsThreadWriter extends Thread {
    public static final String NEW_STRING = "\n";

    private User user;

    public WeekPasswordsThreadWriter(User user) {
        this.user = user;
    }

    public synchronized void writeInFileWeekPasswordUser() throws IOException {
        BufferedWriter oWriter = new BufferedWriter(new FileWriter(FilesInitializer.WEEK_PASSWORD_USERS_TXT, true));
        oWriter.write(user.toString() + NEW_STRING);
        oWriter.close();
    }

    @Override
    public void run() {
        try {
            writeInFileWeekPasswordUser();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

