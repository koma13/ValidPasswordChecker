package com.services;

import com.constants.Constants;
import com.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Serializer extends Thread {

    private static Path userTempFile(User user) throws IOException {
        return Files.createTempFile(Constants.FILE_NAME_START_WITH + user.getName(), Constants.TXT_EXTENSION);
    }

    public static File serializeUserToTempFile(User user) {
        File file = null;
        ObjectOutput output = null;

        try {
            file = userTempFile(user).toFile();
            FileOutputStream out = new FileOutputStream(file);
            output = new ObjectOutputStream(out);
            output.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(output!=null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public static User deserializeFileContentToObjects(File file) {
        try (ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
           return (User) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Deserialization failed");
        }
    }
}