package task12.cat;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RelocateCats {

    private String source;
    private String target;

    public RelocateCats(String source, String target) {
        this.source = source;
        this.target = target;
        relocateSystem(this.source, this.target);
    }

    private void relocateSystem(String source, String target) {

        ArrayList<String> catsList = new ArrayList<>();

        final String sourceWay = "src/task12/resources/" + source;
        final String targetWay = "src/task12/resources/" + target;

        File sourceFile = new File(sourceWay);
        File targetFile = new File(targetWay);

        if (sourceFile.exists() && targetFile.exists()) {
            try (Scanner scanner_target = new Scanner(targetFile);
                 Scanner scanner_source = new Scanner(sourceFile)) {
                while (scanner_target.hasNext()) {
                    String cat = scanner_target.next();
                    catsList.add(cat);
                }
                while (scanner_source.hasNext()) {
                    String cat = scanner_source.next();
                    catsList.add(cat);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            try (FileWriter fw = new FileWriter(targetWay)) {
                for (String s : catsList) {
                    fw.write(s + " ");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Коты успешно перенесены");
        }
        else
            System.out.println("Одного из этих питомников нет в списке");
    }
}
