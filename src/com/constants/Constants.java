package com.constants;

public final class Constants {

    private Constants() {
    }

    public static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    public static final String TXT_EXTENSION = ".txt";
    public static final String FILE_NAME_START_WITH = "thread";
    public static final String USERS_WITH_STRONG_PASSWORD_MSG = "\n" + "Users with strong password : ";
    public static final String USERS_TXT = "users.txt";

}
