package com.setup;

import com.services.StrongPasswordsThreadWriter;

import java.io.*;
import java.util.List;

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
        }else {
            cleanFile(file);
        }
    }

    private static void cleanFile(File file) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print(EMPTY_FILE);
        writer.close();
    }

    private static void deleteFilesInStrongPassFolder(File folder) throws IOException {
        File[] files = folder.listFiles();
        for(File file: files){
                file.delete();
        }
    }
}
