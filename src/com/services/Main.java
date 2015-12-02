package com.services;


import com.setup.FilesInitializer;
import com.model.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mariia_Kogut on 11/26/2015.
 */
public class Main {

    static List<User> usersList;

    public static void main(String[] args) throws IOException, InterruptedException {

        FilesInitializer.initializeFiles();

            usersList = FileReader.readFromFile();

        for (User user : usersList) {
            try {
                PasswordValidator.validatePassword(user);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        StrongPasswordsThreadWriter.strongPasswordsUsersSortedSysout();
    }
}

