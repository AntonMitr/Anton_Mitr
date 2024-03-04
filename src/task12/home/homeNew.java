package task12.home;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class homeNew implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public homeNew (String name){
        this.name = name;
        addHome(this.name);
    }

    private void addHome(String name){
        try {
            File file = new File("src/task12/resources/" + name);
            if(file.createNewFile())
                System.out.println("Новый питомник успешно добавлен");
        } catch (IOException ex){
            System.out.println("Ошибка при добавлении питомника");
        }
    }

}
