package com.services;

import com.annotation.ValidatePass;
import com.model.User;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Mariia_Kogut on 12/2/2015.
 */
public class AnnotationParsing {

    private static String annotatedField;

    public static String getAnnotatedUserField(User user) throws IllegalAccessException, IOException, ClassNotFoundException {
        for (Field field : User.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ValidatePass.class)) {
                annotatedField = field.get(user).toString();
                return annotatedField;
            }
        }
        return "";
    }
}
