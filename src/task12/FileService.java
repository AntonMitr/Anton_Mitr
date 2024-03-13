package task12;

import java.io.File;
import java.io.IOException;

import static task12.HomeService.link;
import static task12.HomeService.link2;

public class FileService {

    public void creatBasicFile() {
        File file = new File(link);
        File file2 = new File(link2);

        try {
            file.createNewFile();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            file2.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
