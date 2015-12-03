package com.services;

import com.constants.Constants;
import com.model.User;

import java.util.List;

public class UserPrinter {

    public static void printOut(List<User> userList) {
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    public static void printMessage() {
        System.out.println(Constants.USERS_WITH_STRONG_PASSWORD_MSG);
    }

    public static void printError(User user) {
        System.err.println(user.toString());
    }
}
