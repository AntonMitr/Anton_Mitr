package task12;

import java.io.File;
import java.io.IOException;

public class HomeService {

    static final String link = "src/task12/resources/homes/";
    static final String link2 = "src/task12/resources/allCats/";

    //создаём файл питомника
    public void newHome(String name) {
        File file = new File(link+name);
        try {
            if (file.createNewFile())
                System.out.println("Новый питомник успешно добавлен");
        } catch (IOException ex){
            System.out.println("Ошибка при добавлении питомника");
        }
    }
}
