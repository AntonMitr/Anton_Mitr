package task13.UI;

import task13.config.Config;
import task13.controller.CatService;
import task13.controller.HomeService;
import task13.model.DataBase;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        this.builder = new Builder();
        this.navigator = new Navigator();

        HomeService homeService = new HomeService();
        CatService catService = new CatService();
        Config config = new Config();

        final boolean CAN_DELETE_HOME = config.getCanDeleteHome();
        final int MAX_CATS_AT_HOME = config.getMaxCatsAtHome();

        DataBase dataBase = DataBase.getDataBase();

        String command;
        builder.buildMenu();

        do {
            navigator.printMenu();

            command = sc.next();
            navigator.navigate(command);
        } while (!command.equalsIgnoreCase("12"));


    }
}
