package helper;

import model.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mariia_Kogut on 11/26/2015.
 */
public class Main {

    public static final String SERIALIZED_USERS_FILE = "serializedUsers.txt";
    static List<User> usersList;

    public static void main(String[] args) {
        new File(ThreadWriter.WEEK_PASSWORD_USERS_TXT).delete();
        try {
//            Files.createTempFile()
            usersList = FileReader.readFromFile();
            usersList.forEach(PasswordValidator::isPasswordStrong);
            //Serializer.serializeObjectsToFile(SERIALIZED_USERS_FILE, PasswordValidator.validPasswordUsers);
           // ThreadWriter.writeInFileSerializedUsersWithStrongPassword();
            // Serializer.deserializeFileContentToObjects(SERIALIZED_USERS_FILE);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}


