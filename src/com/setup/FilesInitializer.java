package com.setup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mariia_Kogut on 12/1/2015.
 */
public class FilesInitializer {

    public static final String WEEK_PASSWORD_USERS_TXT = "weekPasswordsOutput.txt";
    public static final String EMPTY_FILE = "";

    public static void initializeFiles() throws IOException {
        createFile(WEEK_PASSWORD_USERS_TXT);
    }

    private static void createFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            cleanFile(file);
        }
    }

    private static void cleanFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(EMPTY_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
