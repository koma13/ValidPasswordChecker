package com.services;


import com.constants.Constants;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator extends Thread {

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isPasswordFieldValid(String passwordField) throws IllegalAccessException, IOException, ClassNotFoundException {
        return (checkValidPasswordMatcher(passwordField));
    }

    private static boolean checkValidPasswordMatcher(String password) {
        pattern = Pattern.compile(Constants.PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }
}

