package helper;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mariia_Kogut on 11/25/2015.
 */
public class FileReader {

    public static final String USERS_TXT = "users.txt";
    public static List<User> users = new ArrayList<>();

    public static List<User> readFromFile() throws IOException {


        File myFile = new File(USERS_TXT);
        Scanner inputFile = new Scanner(myFile);

        while (inputFile.hasNext()) {


            User user = new User(Integer.parseInt(inputFile.nextLine()),
                   inputFile.nextLine(),
                   inputFile.nextLine(),
                   inputFile.nextLine(),
                   inputFile.nextLine());
           user.toString();
            inputFile.nextLine();
            users.add(user);
        }
        return users;
    }
}



