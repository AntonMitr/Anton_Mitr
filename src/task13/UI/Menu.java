package task13.UI;

import java.awt.*;
import java.util.HashMap;

public class Menu {

    private static Menu menu;
    private String name;
    private HashMap<String, MenuItem> menuItems;

    private Menu() {

    }

    public static synchronized Menu getMenu() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(HashMap<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
