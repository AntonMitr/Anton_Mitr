package task12.cat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListCats {

    public ListCats() {
        AllCats();
    }

    private void AllCats() {

        ArrayList<String> catsList = new ArrayList<>();

        File resources = new File("src//task12/resources");
        File[] listOfFiles = resources.listFiles();
        for (File file : listOfFiles) {

            String homeName = file.getName();

            try (Scanner scanner = new Scanner(new File("src/task12/resources/" + homeName))) {
                while (scanner.hasNext()) {
                    String cat = scanner.next();
                    catsList.add(cat);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (String s : catsList)
            System.out.print(s + " ");

    }
}