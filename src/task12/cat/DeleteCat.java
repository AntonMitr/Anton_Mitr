package task12.cat;

import task12.Cats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteCat extends Cats {

        public DeleteCat(String name, String home) {
            super(name, home);

            DelCat(home, name);
        }

        private void DelCat(String home, String name) {
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

                try (FileWriter fw = new FileWriter(homeWay)) {
                    for (int i = 0; i < catsList.size(); i++) {
                        if (name.equals(catsList.get(i)))
                            continue;
                        else
                            fw.write(catsList.get(i) + " ");
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Кот успешно удален из питомника");
            }
            else System.out.println("Такого питомника не существует");
        }
}
