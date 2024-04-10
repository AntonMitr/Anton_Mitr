package task13.UI;

import task13.config.Config;
import task13.controller.CatService;
import task13.controller.HomeService;
import task13.model.Cat;
import task13.model.DataBase;

import java.util.ArrayList;
import java.util.Scanner;


public class Builder {

    private static Builder builder;
    private final Menu rootMenu = new Menu();
    private final HomeService homeService;
    private final CatService catService;
    private final Config config;
    private final ArrayList<MenuItem> rootMenuItems = new ArrayList<>();
    private final DataBase dataBase;

    private Builder() {
        this.homeService = new HomeService();
        this.catService = new CatService();
        this.dataBase = DataBase.getDataBase();
        this.config = new Config();
    }

    public static synchronized Builder getBuilder() {
        if (builder == null) {
            builder = new Builder();
        }
        return builder;
    }

    public void buildMenu() {

        IAction iAction = () -> {
            Scanner sc = new Scanner(System.in);

            if (config.getCanDeleteHome()) {
                System.out.println("Введите название нового питомника");
                homeService.creatNewHome(sc.next());
            } else {
                System.out.println("Извините, но данная функция недоступна");
            }
        };

        rootMenuItems.add(new MenuItem(EnumCommands.ADD_HOME.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя котика и название питомника, в который хотите его добавить");
            Cat cat = catService.getCat(sc.next(), sc.next());

            if (!(catService.countCatsAtHome(cat.getHome()) > config.getMaxCatsAtHome())) {
                catService.addNewCat(cat);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
            }
        };
        rootMenuItems.add(new MenuItem(EnumCommands.ADD_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя кота и питомник, откуда он уехал");
            Cat cat1 = catService.getCat(sc.next(), sc.next());
            catService.deleteCat(cat1);
        };
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
            String homeSource = sc.next();
            String homeTarget = sc.next();

            if (!(catService.countCatsAtHome(homeTarget) > config.getMaxCatsAtHome())) {
                catService.relocateCats(homeSource, homeTarget);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
            }
        };
        rootMenuItems.add(new MenuItem(EnumCommands.REPLACE.getEnumCommand(), iAction));

        iAction = () -> {
            System.out.print("Все коты, которые есть у нас в питомниках: \n");
            catService.printAllCats();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_ALL_CATS.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника про который хотите узнать больше");
            String home = sc.next();
            System.out.println("Все коты проживающие в питомнике: ");
            homeService.printCatsAtHome(home);
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CATS.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя котика о котором хотите получить информацию");
            String name = sc.next();
            catService.printCatInfo(name);
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            System.out.print("Все питомники, которые есть у нас в базе: \n");
            homeService.printAllHomes();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_HOME.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите имя кота и питомник, в котором он находится");
            Cat cat2 = new Cat(sc.next(), sc.next());

            System.out.println("Введите новые имя и питомник");
            String newName = sc.next();
            String newHome = sc.next();

            if (!(catService.countCatsAtHome(newHome) > config.getMaxCatsAtHome())) {
                catService.editCatInfo(cat2, newName, newHome);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
            }
        };
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_CAT_INFO.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника, информацию о котором хотите изменить");
            String oldHome = sc.next();
            System.out.println("Введите новое название питомника");
            String newHome1 = sc.next();
            homeService.editHomeInfo(oldHome, newHome1);
        };
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_HOME_INFO.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);

            System.out.println("Введите название питомника, который будет удалён");
            String oldHome1 = sc.next();

            System.out.println("Введите название питомника, в который переселим котов");
            String home2 = sc.next();

            if (!(catService.countCatsAtHome(home2) > config.getMaxCatsAtHome())) {
                catService.relocateCats(oldHome1, home2);
                homeService.deleteHome(oldHome1);
            } else {
                System.out.println("Извинте, но питомник не может содержать больше " + config.getMaxCatsAtHome() + " котов. Операция отменена.");
            }
        };
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_HOME_AND_REPLACE_CATS.getEnumCommand(), iAction));


        rootMenu.setMenuItems(rootMenuItems);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}