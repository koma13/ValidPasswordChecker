package com.services;

import com.constants.Constants;
import com.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<User> readFromFile() throws IOException {
        List<User> users = new ArrayList<>();
        File myFile = new File(Constants.USERS_TXT);
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



