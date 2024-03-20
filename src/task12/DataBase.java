package task12;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static task12.FileCreator.creatFile;

public class DataBase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private static List<Cat> catList = new ArrayList<>();
    private static HashSet<String> homeList = new HashSet<>();
    private static DataBase dataBase;
    private static final String LINK = "src/task12/resources/cats.bin";

    private DataBase() {
        deserializeCats();
    }

    public static synchronized DataBase getDataBase() { // добавляем "synchronized" для работы в многопоточной среде
        if (dataBase == null) {
            creatFile(LINK);
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public void serializeCats() {
        try (FileOutputStream fos = new FileOutputStream(LINK);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Cat cat : catList) {
                oos.writeObject(cat);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void deserializeCats(){
        try (FileInputStream fis = new FileInputStream(LINK);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Cat cat = (Cat) ois.readObject();
                    catList.add(cat);
                    homeList.add(cat.getHome());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Cat> getCatList(){
        return catList;
    }

    public HashSet<String> getHomeList(){
        return homeList;
    }

}
