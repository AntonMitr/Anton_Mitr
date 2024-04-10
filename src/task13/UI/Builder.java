package task13.UI;

import task13.controller.CatService;
import task13.controller.HomeService;

import java.util.ArrayList;
import java.util.Scanner;


public class Builder {

    private static Builder builder;
    private final Menu rootMenu = new Menu();
    private final HomeService homeService;
    private final CatService catService;

    private Builder() {
        this.homeService = new HomeService();
        this.catService = new CatService();
    }

    public static synchronized Builder getBuilder() {
        if (builder == null) {
            builder = new Builder();
        }
        return builder;
    }

    public void buildMenu() {
        final ArrayList<MenuItem> rootMenuItems = new ArrayList<>();

        IAction iAction = () -> {
            homeService.creatNewHome();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.ADD_HOME.getEnumCommand(), iAction));

        iAction = () -> {
            catService.addNewCat();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.ADD_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            Scanner sc = new Scanner(System.in);
            catService.deleteCat();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            catService.relocateCats();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.REPLACE.getEnumCommand(), iAction));

        iAction = () -> {
            catService.printAllCats();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_ALL_CATS.getEnumCommand(), iAction));

        iAction = () -> {
            homeService.printCatsAtHome();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CATS.getEnumCommand(), iAction));

        iAction = () -> {
            catService.printCatInfo();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CAT.getEnumCommand(), iAction));

        iAction = () -> {
            homeService.printAllHomes();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_HOME.getEnumCommand(), iAction));

        iAction = () -> {
            catService.editCatInfo();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_CAT_INFO.getEnumCommand(), iAction));

        iAction = () -> {
            homeService.editHomeInfo();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_HOME_INFO.getEnumCommand(), iAction));

        iAction = () -> {
            homeService.deleteHome();
        };
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_HOME_AND_REPLACE_CATS.getEnumCommand(), iAction));


        rootMenu.setMenuItems(rootMenuItems);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}