package task14.UI;

import java.util.ArrayList;

public class Menu {

    private String name;
    private ArrayList<MenuItem> menuItems;

    public Menu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
