package task13.UI;

import task13.config.Config;
import task13.controller.CatService;
import task13.controller.HomeService;
import task13.model.DataBase;

import java.util.Scanner;

public class MenuItem implements IAction{

    private String title;
    private IAction iAction;

    public IAction getiAction() {
        return iAction;
    }

    public void setIAction(IAction iAction) {
        this.iAction = iAction;
    }

    public MenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void doAction() {
        HomeService homeService = new HomeService();
        CatService catService = new CatService();
        Config config = new Config();

        final boolean CAN_DELETE_HOME = config.getCanDeleteHome();
        final int MAX_CATS_AT_HOME = config.getMaxCatsAtHome();

        DataBase dataBase = DataBase.getDataBase();

        iAction.execute(CAN_DELETE_HOME, MAX_CATS_AT_HOME, homeService, catService, dataBase);

        }

    @Override
    public void execute(boolean CAN_DELETE_HOME, int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase) {

    }
}

