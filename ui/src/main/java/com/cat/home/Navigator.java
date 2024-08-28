package com.cat.home;

public class Navigator {

    @DIAnnotation
    private Menu currentMenu;
    @DIAnnotation
    private Builder builder;

    public Navigator() {
        DIAnnotationService.processingDI(this);
        builder.buildMenu();
        this.currentMenu = builder.getRootMenu();
    }

    public void printMenu() {
        System.out.println("\nВ нашей программе доступны следующие команды:");
        for (int i = 0; i < currentMenu.getMenuItems().size(); i++) {
            System.out.println(i + 1 + ". " + currentMenu.getMenuItems().get(i).getTitle());
        }
    }

    public void navigate(String command) {
        try {
            currentMenu.getMenuItems().get(Integer.parseInt(command) - 1).doAction();
        } catch (NumberFormatException ex) {
            if (command.equalsIgnoreCase("exit")) {
                DataBase dataBase = DataBase.getDataBase();
                dataBase.serializeCats();
                System.out.println("Программа завершает свою работу. Ждём ваш позже");
            } else {
                System.out.println("Не правильная команда!!!");
            }
        } catch (RuntimeException ex) {
            System.out.println("Не правильная команда!!!");
        }
    }

}
