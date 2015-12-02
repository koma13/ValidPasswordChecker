package com.services;

import com.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer  extends Thread{
    public static List<User> deserializedStrongPasswordUsers = new ArrayList<>();


    private static String deserializedUserFileName(User user){
        return "thread" + user.getName() + ".txt";
    }

    public static synchronized void serializeAndDeserializeUser(User user)  {
        OutputStream serializationFile;
        try {
            File tmpFile = File.createTempFile("thread" + user.getName(), ".txt");
            serializationFile = new FileOutputStream(tmpFile);
        BufferedOutputStream serializationBuffer = new BufferedOutputStream(serializationFile);
        ObjectOutput output = new ObjectOutputStream(serializationBuffer);
        output.writeObject(user);
        output.flush();
        output.close();
        InputStream file = new FileInputStream(tmpFile);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
            User u = (User)input.readObject();
            deserializedStrongPasswordUsers.add(u);
        input.close();
        file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void deserializeFileContentToObjects(User user) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(deserializedUserFileName(user));
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        deserializedStrongPasswordUsers.add((User)input.readObject());
        input.close();
        file.close();

    }


}
