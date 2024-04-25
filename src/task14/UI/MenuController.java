package task14.UI;

import task14.annotation.DIAnnotationService;
import task14.annotation.NavigatorDI;

import java.util.Scanner;

public class MenuController {

    @NavigatorDI
    private Navigator navigator;

    public MenuController() {
        DIAnnotationService.processingDI(this);
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
