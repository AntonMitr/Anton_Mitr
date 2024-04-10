package task13.UI;

import task13.model.DataBase;

public class Navigator {

    private Menu currentMenu;
    private Builder builder = Builder.getBuilder(); // builder single ton????

    public Navigator() {
        this.currentMenu = builder.getRootMenu();
    }

    public void printMenu() {
        System.out.println("\nВ нашей программе доступны следующие команды:");
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            System.out.println(i + 1 + ". " + currentMenu.getMenuItems().get(i).getTitle());
        }
    }

    public void navigate(String command) {
        if (command.equalsIgnoreCase("exit")) {
            DataBase dataBase = DataBase.getDataBase();
            dataBase.serializeCats();
            System.out.println("Программа завершает свою работу. Ждём ваш позже");
        } else {
            try {
                currentMenu.getMenuItems().get(Integer.parseInt(command) - 1).doAction();
            } catch (RuntimeException ex) {
                System.out.println("Не правильная команда!!!");
            }
        }
    }
}
