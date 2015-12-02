package com.services;


import com.model.User;
import com.setup.FilesInitializer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mariia_Kogut on 11/26/2015.
 */
public class Main {
    private static List<User> usersList;

    public static void main(String[] args) throws IOException, InterruptedException {
        FilesInitializer.initializeFiles();
        usersList = FileReader.readFromFile();

        for (User user : usersList) {
            try {
                PasswordValidator.validatePassword(user);
            } catch (IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        StrongPasswordsThreadWriter.strongPasswordsUsersSortedSysout();
    }
}

