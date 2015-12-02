package com.services;

import com.comparator.UserComparator;
import com.model.User;

import java.util.Collections;

public class StrongPasswordsThreadWriter extends Thread {

    private User user;

    public StrongPasswordsThreadWriter(User user) {
        this.user = user;
    }

    @Override
    public void run()
    {
        new Serializer().serializeAndDeserializeUser(user);
    }

    public static void strongPasswordsUsersSortedSysout() {
        Collections.sort(Serializer.deserializedStrongPasswordUsers, new UserComparator());
        System.out.println( "\n" + "Users with strong password : " );
        for (User user : PasswordValidator.validPasswordUsers) {
            System.out.println(user.toString());
        }
    }
}
