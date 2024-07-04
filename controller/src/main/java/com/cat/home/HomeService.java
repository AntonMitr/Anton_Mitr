package com.cat.home;

import java.util.Scanner;

public class HomeService {

    @DIAnnotation
    private Config config;
    private final DataBase dataBase = DataBase.getDataBase();
    @DIAnnotation
    private CatService catService;
    private Scanner sc = new Scanner(System.in);

    public HomeService() {
        DIAnnotationService.processingDI(this);
    }

    //Добавляем в список(homesList) новый дом
    public void creatNewHome() {
        System.out.println("Введите название нового питомника");
        String newHome = sc.next();
        if (!dataBase.getHomeList().contains(newHome)) {
            dataBase.getHomeList().add(newHome);
        } else {
            System.out.println("Данный питомник уже существует в базе");
        }
    }

    //Выводит на экран список всех котов из x питомника
    public void printCatsAtHome() {
        System.out.println("Введите название питомника про который хотите узнать больше");
        String home = sc.next();
        System.out.println("Все коты проживающие в питомнике: ");
        for (Cat cat : dataBase.getCatList()) {
            if (cat.getHome().equalsIgnoreCase(home)) {
                System.out.print(cat.getName() + " ");
            }
        }
    }

    //Выводт на экран список всех питомников
    public void printAllHomes() {
        System.out.print("Все питомники, которые есть у нас в базе: \n");
        for (String homeName : dataBase.getHomeList()) {
            System.out.print(homeName + " ");
        }
    }

    public void editHomeInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите название питомника, информацию о котором хотите изменить");
        String oldHome = sc.next();
        System.out.println("Введите новое название питомника");
        String newHome = sc.next();
        for (String home : dataBase.getHomeList()) {
            if (home.equalsIgnoreCase(oldHome)) {
                CatService catService = new CatService();
                catService.relocateCats(oldHome, newHome);

                dataBase.getHomeList().remove(home);
                dataBase.getHomeList().add(newHome);
                break;
            }
        }
    }

    public void deleteHome() {
        System.out.println("Введите название питомника, который будет удалён");
        String oldHome = sc.next();

        System.out.println("Введите название питомника, в который переселим котов");
        String newHome = sc.next();

        if (!((catService.countCatsAtHome(oldHome) + catService.countCatsAtHome(newHome)) > config.getMaxCatsAtHome())) {
            catService.relocateCats(oldHome, newHome);
            for (String home : dataBase.getHomeList()) {
                if (home.equalsIgnoreCase(oldHome)) {
                    dataBase.getHomeList().remove(home);
                }
            }
        } else {
            System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
        }
    }

}
