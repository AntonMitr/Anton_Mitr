package task12.cat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AboutHome {
    private String home;

    public AboutHome(String home){
        this.home = home;
        Cats_List(home);
    }

    private void Cats_List(String home) {
        ArrayList<String> catsList = new ArrayList<>();

        final String homeWay = "src/task12/resources/" + home;
        File file = new File(homeWay);

        if(file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String cat = scanner.next();
                    catsList.add(cat);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            for (int i = 0; i < catsList.size(); i++)
                System.out.print(catsList.get(i) + " ");
        }
        else
            System.out.println("Такого питомника не существует");
    }
}
