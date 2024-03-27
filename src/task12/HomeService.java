package task12;

import java.util.HashSet;
import java.util.List;

public class HomeService {

    DataBase dataBase = DataBase.getDataBase();

    private List<Cat> catList = dataBase.getCatList();
    private HashSet<String> homeList = dataBase.getHomeList();

    //Добавляем в список(homesList) новый дом
    public void creatNewHome(String homeName) {
        homeList.add(homeName);
    }

    //Выводит на экран список всех котов из x питомника
    public void printCatsAtHome(String home) {
        for (Cat cat : catList) {
            if (cat.getHome().equalsIgnoreCase(home)) {
                System.out.print(cat.getName() + " ");
            }
        }
    }

    //Выводт на экран список всех питомников
    public void printAllHomes() {
        for (String homeName : homeList) {
            System.out.print(homeName + " ");
        }
    }
}
