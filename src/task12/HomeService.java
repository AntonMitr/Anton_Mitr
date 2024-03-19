package task12;

import java.io.File;
import java.io.IOException;

public class HomeService {

    protected static final String link = "src/task12/resources/";

    //Добавляем в список(homesList) новый дом
    public void creatNewHome(String homeName) {
        if (!DataBase.homesList.contains(homeName)) {
            DataBase.homesList.add(homeName);
        } else {
            System.out.println("Такой питомник уже существует");
        }
    }

    //Выводит на экран список всех котов из x питомника
    public void printCatsAtHome(String home) {
        for (Cat o : DataBase.catsList) {
            if (o.getHome().equalsIgnoreCase(home)) {
                System.out.print(o.getName() + " ");
            }
        }
    }

    //Выводт на экран список всех питомников
    public void printAllHomes(){
        for(String homeName: DataBase.homesList){
            System.out.print(homeName + " ");
        }
    }
}
