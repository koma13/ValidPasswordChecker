package helper;

import model.User;

import java.io.*;
import java.util.*;

/**
 * Created by Mariia_Kogut on 11/26/2015.
 */
public class Serializer  extends Thread{
    private static String fileName;
    private static List<User> users;

    public Serializer(String fileName,  List<User> users){
        this.fileName = fileName;
        this.users = users;
    }

    public void run()
    {

        serializeObjectsToFile();
    }


    public static void serializeObjectsToFile()  {
        // TODO serialize in separate threads
        OutputStream serializationFile = null;
        try {
            serializationFile = new FileOutputStream(fileName);
        BufferedOutputStream serializationBuffer = new BufferedOutputStream(serializationFile);
        ObjectOutput output = new ObjectOutputStream(serializationBuffer);
        output.writeObject(users);
        output.flush();
        output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User deserializeFileContentToObjects(String fileName) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(fileName);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);
        List<User> recoveredUsers = (ArrayList<User>) input.readObject();
        input.close();
        file.close();

        Collections.sort(recoveredUsers, new UserComparator());

        for (User user : recoveredUsers) {
            System.out.println("User with strong password -----> " + user.toString());
        }

        return null;
    }
}
