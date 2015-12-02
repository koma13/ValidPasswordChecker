package com.services;

import com.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static final String USERS_TXT = "users.txt";

    public static List<User> readFromFile() throws IOException {
        List<User> users = new ArrayList<>();
        File myFile = new File(USERS_TXT);
        Scanner inputFile = new Scanner(myFile);

        while (inputFile.hasNext()) {
            User user = new User(Integer.parseInt(inputFile.nextLine()),
                    inputFile.nextLine(),
                    inputFile.nextLine(),
                    inputFile.nextLine(),
                    inputFile.nextLine());
            inputFile.nextLine();
            users.add(user);
        }
        return users;
    }
}



