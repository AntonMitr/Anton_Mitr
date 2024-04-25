package task14.controller;

import task14.config.Config;
import task14.model.Cat;
import task14.model.DataBase;

import java.util.Scanner;

public class CatService {

    private final DataBase dataBase = DataBase.getDataBase();
    private final Config config = new Config();
    private Scanner sc = new Scanner(System.in);

    public void deleteCat() {
        //Убирет кота из списка catsList
        System.out.println("Введите имя кота и питомник, откуда он уехал");
        Cat cat = getCat(sc.next(), sc.next());

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
    public void relocateCats() {
        System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
        String homeSource = sc.next();
        String homeTarget = sc.next();

        if (!((countCatsAtHome(homeTarget) + countCatsAtHome(homeSource)) > config.getMaxCatsAtHome())) {
            if (dataBase.getHomeList().contains(homeSource) || dataBase.getHomeList().contains(homeTarget)) {
                for (Cat cat : dataBase.getCatList()) {
                    if (homeSource.equalsIgnoreCase(cat.getHome())) {
                        cat.setHome(homeTarget);
                    }
                }
            } else {
                System.out.println("Одного из питомников не существует");
            }
        } else {
            System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
        }
    }

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
        System.out.print("Все коты, которые есть у нас в питомниках: \n");
        for (Cat cat : dataBase.getCatList()) {
            System.out.print(cat.getName() + " ");
        }
    }

    //Выводит информаицю об одном из объектов Cat
    public void printCatInfo() {
        System.out.println("Введите имя котика о котором хотите получить информацию");
        String name = sc.next();
        for (Cat cat : dataBase.getCatList()) {
            if (cat.getName().equalsIgnoreCase(name)) {
                System.out.println("Моё имя " + cat.getName() + ". Я живу в " + cat.getHome());
            }
        }
    }

    public void addNewCat() {
        System.out.println("Введите имя котика и название питомника, в который хотите его добавить");
        Cat cat = new Cat(sc.next(), sc.next());

        if (dataBase.getHomeList().contains(cat.getHome())) {
            if (!(countCatsAtHome(cat.getHome()) > config.getMaxCatsAtHome())) {
                dataBase.getCatList().add(cat);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
            }
        } else {
            System.out.println("Такой питомника не существует");
        }
    }

    public void editCatInfo() {

        System.out.println("Введите имя кота и питомник, в котором он находится");
        Cat cat = new Cat(sc.next(), sc.next());

        System.out.println("Введите новые имя и питомник");
        String newName = sc.next();
        String newHome = sc.next();

        if (!(countCatsAtHome(newHome) > config.getMaxCatsAtHome())) {
            if (dataBase.getCatList().contains(cat)) {
                for (Cat cat1 : dataBase.getCatList()) {
                    if (cat1.equals(cat)) {
                        cat1.setName(newName);
                        cat1.setHome(newHome);
                    }
                    break;
                }
            } else {
                System.out.println("Такого кота нет в питомниках");
            }
        } else {
            System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
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
