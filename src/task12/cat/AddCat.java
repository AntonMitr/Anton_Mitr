package task12.cat;

import task12.Cats;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCat extends Cats implements Serializable {
    private static final long serialVersionUID = 1L;

    public AddCat(String name, String home) {
        super(name, home);

        readAtHome(name,home);
        addInfoAdoutCats(name, home);
    }

    private void readAtHome(String name, String home) {
        ArrayList<String> catsList = new ArrayList<>();

        final String homeWay = "src/task12/resources/" + home;
        File file = new File(homeWay);
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String cat = scanner.next();
                catsList.add(cat);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if(file.exists()){
            try(FileWriter fw = new FileWriter(homeWay)){
                catsList.add(name);
                for(int i = 0; i < catsList.size(); i++){
                    fw.write(catsList.get(i)+" ");
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Новый кот успешно добавлен в питомник");
        }
        else System.out.println("Такого питомника не существует");
    }

    private void addInfoAdoutCats(String name, String home){
        Cats cat = new Cats(name, home);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/task12/resources/all.cats" + name))){
            oos.writeObject(cat);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
