package task13.UI;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = Builder.getBuilder();
        this.navigator = new Navigator();
        builder.buildMenu();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        String command;
        do {
            navigator.printMenu();

            command = sc.next();
            navigator.navigate(command);
        } while (!command.equalsIgnoreCase("exit"));


    }
}
