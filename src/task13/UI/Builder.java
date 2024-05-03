package task13.UI;

import task13.config.Config;
import task13.controller.CatService;
import task13.controller.HomeService;
import task13.model.Cat;
import task13.model.DataBase;

import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;


public class Builder {

    private Menu rootMenu = Menu.getMenu();

    public Builder() {
    }

    public void buildMenu() {

        HashMap<String, MenuItem> menuItems = new HashMap<>();

        menuItems.put("1", new MenuItem(EnumCommads.FIRST.getMenuCommand()));

        IAction iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            if (CAN_DELETE_HOME) {
                System.out.println("Введите название нового питомника");
                homeService.creatNewHome(sc.next());
            } else {
                System.out.println("Извините, но данная функция недоступна");
            }
        };
        menuItems.get("1").setIAction(iAction);

        menuItems.put("2", new MenuItem(EnumCommads.SECOND.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя котика и название питомника, в который хотите его добавить");
            Cat cat = catService.getCat(sc.next(), sc.next());

            if (!(catService.countCatsAtHome(cat.getHome()) > MAX_CATS_AT_HOME)) {
                catService.addNewCat(cat);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + MAX_CATS_AT_HOME + " котов. Операция отменена.");
            }
        };
        menuItems.get("2").setIAction(iAction);

        menuItems.put("3", new MenuItem(EnumCommads.THIRD.getMenuCommand()));
        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService,DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя кота и питомник, откуда он уехал");
            Cat cat1 = catService.getCat(sc.next(), sc.next());
            catService.deleteCat(cat1);
        };
        menuItems.get("3").setIAction(iAction);

        menuItems.put("4", new MenuItem(EnumCommads.FOURTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
            String homeSource = sc.next();
            String homeTarget = sc.next();

            if (!(catService.countCatsAtHome(homeTarget) > MAX_CATS_AT_HOME)) {
                catService.relocateCats(homeSource, homeTarget);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + MAX_CATS_AT_HOME + " котов. Операция отменена.");
            }
        };
        menuItems.get("4").setIAction(iAction);

        menuItems.put("5", new MenuItem(EnumCommads.FIFTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            System.out.print("Все коты, которые есть у нас в питомниках: \n");
            catService.printAllCats();
        };
        menuItems.get("5").setIAction(iAction);

        menuItems.put("6", new MenuItem(EnumCommads.SIXTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника про который хотите узнать больше");
            String home = sc.next();
            System.out.println("Все коты проживающие в питомнике: ");
            homeService.printCatsAtHome(home);
        };
        menuItems.get("6").setIAction(iAction);

        menuItems.put("7", new MenuItem(EnumCommads.SEVENTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя котика о котором хотите получить информацию");
            String name = sc.next();
            catService.printCatInfo(name);
        };
        menuItems.get("7").setIAction(iAction);

        menuItems.put("8", new MenuItem(EnumCommads.EIGHTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            System.out.print("Все питомники, которые есть у нас в базе: \n");
            homeService.printAllHomes();
        };
        menuItems.get("8").setIAction(iAction);

        menuItems.put("9", new MenuItem(EnumCommads.NINTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя кота и питомник, в котором он находится");
            Cat cat2 = new Cat(sc.next(), sc.next());

            System.out.println("Введите новые имя и питомник");
            String newName = sc.next();
            String newHome = sc.next();

            if (!(catService.countCatsAtHome(newHome) > MAX_CATS_AT_HOME)) {
                catService.editCatInfo(cat2, newName, newHome);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + MAX_CATS_AT_HOME + " котов. Операция отменена.");
            }
        };
        menuItems.get("9").setIAction(iAction);

        menuItems.put("10", new MenuItem(EnumCommads.TENTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника, информацию о котором хотите изменить");
            String oldHome = sc.next();
            System.out.println("Введите новое название питомника");
            String newHome1 = sc.next();
            homeService.editHomeInfo(oldHome, newHome1);
        };
        menuItems.get("10").setIAction(iAction);

        menuItems.put("11", new MenuItem(EnumCommads.ELEVENTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника, который будет удалён");
            String oldHome1 = sc.next();

            System.out.println("Введите название питомника, в который переселим котов");
            String home2 = sc.next();

            if (!(catService.countCatsAtHome(home2) > MAX_CATS_AT_HOME)) {
                catService.relocateCats(oldHome1, home2);
                homeService.deleteHome(oldHome1);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + MAX_CATS_AT_HOME + " котов. Операция отменена.");
            }
        };
        menuItems.get("11").setIAction(iAction);

        menuItems.put("12", new MenuItem(EnumCommads.TWELFTH.getMenuCommand()));

        iAction = (boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) -> {
            dataBase.serializeCats();
            System.out.println("Программа завершает свою работу. Ждём ваш позже");
        };
        menuItems.get("12").setIAction(iAction);


        rootMenu.setMenuItems(menuItems);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
