package task13.controller;

import task13.model.Cat;
import task13.model.DataBase;

public class HomeService {

    private DataBase dataBase = DataBase.getDataBase();

    //Добавляем в список(homesList) новый дом
    public void creatNewHome(String homeName) {
        dataBase.getHomeList().add(homeName);
    }

    //Выводит на экран список всех котов из x питомника
    public void printCatsAtHome(String home) {
        for (Cat cat : dataBase.getCatList()) {
            if (cat.getHome().equalsIgnoreCase(home)) {
                System.out.print(cat.getName() + " ");
            }
        }
    }

    //Выводт на экран список всех питомников
    public void printAllHomes() {
        for (String homeName : dataBase.getHomeList()) {
            System.out.print(homeName + " ");
        }
    }

    public void editHomeInfo(String nameHome, String newNameHome) {
        for (String home : dataBase.getHomeList()) {
            if (home.equalsIgnoreCase(nameHome)) {
                CatService catService = new CatService();
                catService.relocateCats(nameHome, newNameHome);

                dataBase.getHomeList().remove(home);
                dataBase.getHomeList().add(newNameHome);
                break;
            }
        }
    }

    public void deleteHome(String name) {
        for (String home : dataBase.getHomeList()) {
            if (home.equalsIgnoreCase(name)) {
                dataBase.getHomeList().remove(home);
            }
        }
    }
}
