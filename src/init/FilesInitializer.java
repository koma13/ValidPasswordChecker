package init;

import java.io.File;

/**
 * Created by Mariia_Kogut on 12/1/2015.
 */
public  class FilesInitializer {

    public static final String WEEK_PASSWORD_USERS_TXT = "output";

    public static void initializeFileFrom() {


        File oFile = new File(WEEK_PASSWORD_USERS_TXT);
        if (!oFile.exists()) {
          //  oFile.createNewFile();
        }
    }
}
