package task12;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatService {

    static final String link2 = "src/task12/resources/allCats/";

    public static ArrayList<String> catsList = new ArrayList<>();
    public static ArrayList<String> catsListRelocate = new ArrayList<>();

    public void addAtCatsList(Cat cat) {

        try (Scanner scanner = new Scanner(new File(HomeService.link + cat.getHome()))) {
            catsList.clear();
            while (scanner.hasNext()) {
                String cat1 = scanner.next();
                catsList.add(cat1);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void relocateCats(String source, String target) {
        final String sourceWay = HomeService.link + source;
        final String targetWay = HomeService.link + target;

        File sourceFile = new File(sourceWay);
        File targetFile = new File(targetWay);

        if (sourceFile.exists() && targetFile.exists()) {
            try (Scanner scanner_target = new Scanner(targetFile);
                 Scanner scanner_source = new Scanner(sourceFile)) {
                while (scanner_target.hasNext()) {
                    String cat = scanner_target.next();
                    catsListRelocate.add(cat);
                }
                while (scanner_source.hasNext()) {
                    String cat = scanner_source.next();
                    catsListRelocate.add(cat);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else
            System.out.println("Одного из этих питомников нет в списке");
    }

    public void creatListOfAllCats() {

        ArrayList<String> catsCreatList = new ArrayList<>();

        File resources = new File(HomeService.link);
        File[] listOfFiles = resources.listFiles();
        for (File file : listOfFiles) {

            String homeName = file.getName();

            try (Scanner scanner = new Scanner(new File(HomeService.link + homeName))) {
                while (scanner.hasNext()) {
                    String cat = scanner.next();
                    catsCreatList.add(cat);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        for (String s : catsCreatList)
            System.out.print(s + " ");

    }
}