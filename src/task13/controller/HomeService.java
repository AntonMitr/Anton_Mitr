package task13.controller;

import task13.model.Cat;
import task13.model.DataBase;

import java.util.HashSet;
import java.util.List;

public class HomeService {

    private List<Cat> catList = DataBase.getDataBase().getCatList();
    private HashSet<String> homeList = DataBase.getDataBase().getHomeList();

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

    public void editHomeInfo(String nameHome, String newNameHome) {
        for (String home : homeList) {
            if (home.equalsIgnoreCase(nameHome)) {
                CatService catService = new CatService();
                catService.relocateCats(nameHome, newNameHome);

                homeList.remove(home);
                homeList.add(newNameHome);
                break;
            }
        }
    }

    public void deleteHome(String name) {
        for (String home : homeList) {
            if (home.equalsIgnoreCase(name)) {
                homeList.remove(home);
            }
        }
    }
}
