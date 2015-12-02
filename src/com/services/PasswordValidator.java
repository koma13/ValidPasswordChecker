package com.services;


import com.annotation.ValidatePass;
import com.model.User;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator extends Thread {

    private static String passwordField;
    private static Pattern pattern;
    private static Matcher matcher;
    public static Map<String, String> invalidPasswordUsersInMap = new LinkedHashMap<>();
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    public static List<User> validPasswordUsers = new ArrayList<>();

    public static void validatePassword(User user) throws IllegalAccessException, IOException, ClassNotFoundException {
        for (Field field : User.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ValidatePass.class)) {
                validatePasswordField(user, field);
            }
        }

    }

    private static void validatePasswordField(User user, Field field) throws IllegalAccessException, IOException, ClassNotFoundException {
        passwordField = field.get(user).toString();
        if (checkValidPasswordMatcher(passwordField)) {
            validPasswordUsers.add(user);
            new StrongPasswordsThreadWriter(user).start();


        } else {
            invalidPasswordUsersInMap.put(user.getLogin(), user.getPassword());
            new WeekPasswordsThreadWriter(user).start();
            System.err.println(user.toString());
        }

    }

    private static boolean checkValidPasswordMatcher(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
