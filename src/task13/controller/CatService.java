package task13.controller;

import task13.model.Cat;
import task13.model.DataBase;

public class CatService {

    private DataBase dataBase = DataBase.getDataBase();

    public void deleteCat(Cat cat) {
        //Убирет кота из списка catsList
        if ((dataBase.getHomeList().contains(cat.getHome())) && (dataBase.getCatList().contains(cat))) {
            for (Cat cat1 : dataBase.getCatList()) {
                if (cat1.equals(cat)) {
                    dataBase.getCatList().remove(cat1);
                    break;
                }
            }
        } else {
            System.out.println("Такого кота или питоника не существует!");
        }
    }

    //Переносит котов из одного питомника в другой
    public void relocateCats(String homeSource, String homeTarget) {
        if (dataBase.getHomeList().contains(homeSource) || dataBase.getHomeList().contains(homeTarget)) {
            for (Cat cat : dataBase.getCatList()) {
                if (homeSource.equalsIgnoreCase(cat.getHome())) {
                    cat.setHome(homeTarget);
                }
            }
        } else {
            System.out.println("Одного из питомников не существует");
        }
    }

    //Выводит всех котов из списка catsList
    public void printAllCats() {
        for (Cat cat : dataBase.getCatList()) {
            System.out.print(cat.getName() + " ");
        }
    }

    //Выводит информаицю об одном из объектов Cat
    public void printCatInfo(String name) {
        for (Cat cat : dataBase.getCatList()) {
            if (cat.getName().equalsIgnoreCase(name)) {
                System.out.println("Моё имя " + cat.getName() + ". Я живу в " + cat.getHome());
            }
        }
    }

    public void addNewCat(Cat cat) {
        if (dataBase.getHomeList().contains(cat.getHome())) {
            dataBase.getCatList().add(cat);
        } else {
            System.out.println("Такой питомника не существует");
        }
    }

    public void editCatInfo(Cat cat, String name, String home) {
        if (dataBase.getCatList().contains(cat)) {
            for (int i = 0; i < dataBase.getCatList().size(); i++) {
                if (dataBase.getCatList().get(i).equals(cat)) {
                    dataBase.getCatList().get(i).setName(name);
                    dataBase.getCatList().get(i).setHome(home);
                }
                break;
            }
        } else {
            System.out.println("Такого кота нет в питомниках");
        }
    }

    public int countCatsAtHome(String home) {
        int counter = 0;
        for (Cat cat : dataBase.getCatList()) {
            if (cat.getHome().equals(home)) {
                counter++;
            }
        }
        return counter;
    }

    public Cat getCat(String catName, String catHome) {
        return new Cat(catName, catHome);
    }
}
