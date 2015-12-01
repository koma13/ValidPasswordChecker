package helper;

import init.FilesInitializer;
import model.User;

import java.io.*;

public class ThreadWriter extends Thread {
    public static final String WEEK_PASSWORD_USERS_TXT = "output";
    private User user;

    public ThreadWriter(User user) {
        this.user = user;
    }

    public static void writeInFileSerializedUsersWithStrongPassword() {

        int threadCount = PasswordValidator.invalidPasswordUsersInMap.size();
        for (int i = 0; i < threadCount; i++) {
            new Serializer("thread" + i + ".txt", PasswordValidator.validPasswordUsers).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void writeInFileWeekPasswordUser() throws IOException {
        BufferedWriter oWriter = new BufferedWriter(new FileWriter(FilesInitializer.WEEK_PASSWORD_USERS_TXT, true));
        oWriter.write(user.toString() + '\n');
        oWriter.close();

    }

    @Override
    public void run() {
        try {
            writeInFileWeekPasswordUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

