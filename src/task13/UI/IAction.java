package task13.UI;

import task13.controller.CatService;
import task13.controller.HomeService;
import task13.model.DataBase;

public interface IAction {

    void execute(boolean CAN_DELETE_HOME,int MAX_CATS_AT_HOME, HomeService homeService, CatService catService, DataBase dataBase);
}
