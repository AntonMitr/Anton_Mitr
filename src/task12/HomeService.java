package task12;

import java.util.HashSet;
import java.util.List;

public class HomeService {

    private List<Cat> catList = DataBase.getDataBase().getCatList();
    private HashSet<String> homeList = DataBase.getDataBase().getHomeList();

    //Добавляем в список(homesList) новый дом
    public void creatNewHome(String homeName) {
            homeList.add(homeName);
            System.out.println("Такой питомник уже существует");
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
