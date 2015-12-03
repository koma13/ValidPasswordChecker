package com.services;

import com.model.User;
import com.setup.FilesInitializer;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        boolean isPasswordValid;
        List<User> usersList;
        String passwordFieldValue;

        FilesInitializer.initializeFiles();
        usersList = FileReader.readFromFile();

        for (User user : usersList) {
            try {
                passwordFieldValue = AnnotationParsing.getAnnotatedUserField(user);
                isPasswordValid = PasswordValidator.isPasswordFieldValid(passwordFieldValue);
                if (isPasswordValid) {
                    StrongPasswordsHandler.processStrongPasswordUser(user);
                } else {
                    WeekPasswordsHandler.processWeekPasswordUser(user);
                }
            } catch (IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        StrongPasswordsHandler.strongPasswordsUsersSortedSysout();
    }
}


