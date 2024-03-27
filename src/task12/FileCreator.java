package task12;

import java.io.File;
import java.io.IOException;

public final class FileCreator {

    public static void creatFile(String LINK) {
        File file = new File(LINK);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
