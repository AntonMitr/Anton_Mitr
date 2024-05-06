package task14.UI;

import task14.annotation.DIAnnotation;
import task14.annotation.DIAnnotationService;
import task14.controller.CatService;
import task14.controller.HomeService;

import java.util.ArrayList;


public class Builder {

    @DIAnnotation
    private Menu rootMenu;
    @DIAnnotation
    private HomeService homeService;
    @DIAnnotation
    private CatService catService;

    public Builder() {
        DIAnnotationService.processingDI(this);
    }

    public void buildMenu() {
        final ArrayList<MenuItem> rootMenuItems = new ArrayList<>();

        IAction iAction = homeService::creatNewHome;
        rootMenuItems.add(new MenuItem(EnumCommands.ADD_HOME.getEnumCommand(), iAction));

        iAction = catService::addNewCat;
        rootMenuItems.add(new MenuItem(EnumCommands.ADD_CAT.getEnumCommand(), iAction));

        iAction = catService::deleteCat;
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_CAT.getEnumCommand(), iAction));

        iAction = catService::relocateCats;
        rootMenuItems.add(new MenuItem(EnumCommands.REPLACE.getEnumCommand(), iAction));

        iAction = catService::printAllCats;
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_ALL_CATS.getEnumCommand(), iAction));

        iAction = homeService::printCatsAtHome;
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CATS.getEnumCommand(), iAction));

        iAction = catService::printCatInfo;
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_CAT.getEnumCommand(), iAction));

        iAction = homeService::printAllHomes;
        rootMenuItems.add(new MenuItem(EnumCommands.INFO_ABOUT_HOME.getEnumCommand(), iAction));

        iAction = catService::editCatInfo;
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_CAT_INFO.getEnumCommand(), iAction));

        iAction = homeService::editHomeInfo;
        rootMenuItems.add(new MenuItem(EnumCommands.CHANGE_HOME_INFO.getEnumCommand(), iAction));

        iAction = homeService::deleteHome;
        rootMenuItems.add(new MenuItem(EnumCommands.DEL_HOME_AND_REPLACE_CATS.getEnumCommand(), iAction));

        iAction = () -> {
        };
        rootMenuItems.add(new MenuItem(EnumCommands.EXIT.getEnumCommand(), iAction));

        rootMenu.setMenuItems(rootMenuItems);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}