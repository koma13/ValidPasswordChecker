package com.services;

import com.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer extends Thread {
    public static List<User> deserializedStrongPasswordUsers = new ArrayList<>();


    private static File userTempFile(User user) throws IOException {
        return File.createTempFile("thread" + user.getName(), ".txt");
    }

    public static synchronized void serializeAndDeserializeUser(User user) {
        try (FileOutputStream out = new FileOutputStream(userTempFile(user));
             ObjectOutput output = new ObjectOutputStream(out)) {
            output.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        deserializeFileContentToObjects(user);
    }

    private static synchronized void deserializeFileContentToObjects(User user) {
        try (ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(userTempFile(user))))) {
            deserializedStrongPasswordUsers.add((User) input.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
