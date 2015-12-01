package helper;

import model.User;

import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mariia_Kogut on 11/27/2015.
 */
public class PasswordValidator  extends Thread{

    private static String passwordField;
    private static Pattern pattern;
    private static Matcher matcher;
    public static Map<String, String> invalidPasswordUsersInMap = new LinkedHashMap<>();
    public static List<User> invalidPasswordUsersList = new ArrayList<>();
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    public static List<User> validPasswordUsers = new ArrayList<>();


    public static void isPasswordStrong(User user) {

        for (Field field : User.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ValidatePass.class)) {
                try {
                    passwordField = field.get(user).toString();
                    if (isPasswordStrong(passwordField)) {
                        validPasswordUsers.add(user);

                    } else {
                        invalidPasswordUsersInMap.put(user.getLogin(), user.getPassword());
                       new ThreadWriter(user).start();
                        System.err.println(user.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isPasswordStrong(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

}
