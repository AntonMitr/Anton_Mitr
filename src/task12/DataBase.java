package task12;

import java.io.*;
import java.util.ArrayList;

public class DataBase implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private static DataBase dataBase;
    private static String link = "D:\\Код\\Itclopedia\\12\\Anton_Mitr\\src\\task12\\resources\\cats.bin";

    protected static ArrayList<Cat> catsList = new ArrayList<Cat>();
    protected static ArrayList<String> homesList = new ArrayList<String>();

    public static synchronized DataBase getProgramLogger(){ // добавляем "synchronized" для работы в многопоточной среде
        if(dataBase == null){
            //Если нет папки с котами, то создаём её
            File file = new File(link);
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            //////////////////////////////////////////

            dataBase = new DataBase();
        }
        return dataBase;
    }

    private DataBase(){
        try(FileInputStream fis = new FileInputStream(link);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            while(true){
                try {
                    Cat cat = (Cat) ois.readObject();
                    catsList.add(cat);
                    if(!homesList.contains(cat.getHome())) {
                        homesList.add(cat.getHome());
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        }catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void serialization(){
        try (FileOutputStream fos = new FileOutputStream(link);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Cat cat : catsList) {
                    oos.writeObject(cat);
                }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
