package com.cat.home;

import java.util.Scanner;

public class MenuController {

    @DIAnnotation
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
