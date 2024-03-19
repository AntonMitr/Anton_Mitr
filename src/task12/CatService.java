package task12;

import java.io.*;
import java.util.ArrayList;

public class CatService {

    //
    public void movingCat(Cat cat) {

        //Убирет кота из списка catsList
        if (!DataBase.homesList.contains(cat.getName()) || !DataBase.catsList.contains(cat)) {
            for (Cat o : DataBase.catsList) {
                if (o.equals(cat)) {
                    DataBase.catsList.remove(o);
                }
            }
        } else {
            System.out.println("Такого кота или питоника не существует!");
        }
    }

    //Переносит котов из одного питомника в другой
    public void relocateCats(String homeSource, String homeTarget) {
        if (!DataBase.homesList.contains(homeSource) || !DataBase.homesList.contains(homeTarget)) {
            for (int i = 0; i < DataBase.catsList.size(); i++) {
                if (homeSource.equalsIgnoreCase(DataBase.catsList.get(i).getHome())) {
                    DataBase.catsList.get(i).setName(homeTarget);
                }
            }
        } else {
            System.out.println("Одного из питомников не существует");
        }
    }

    //Выводит всех котов из списка catsList
    public void printAllCats(){
        for(Cat o: DataBase.catsList){
            System.out.print(o.getName() + " ");
        }
    }

    //Выводит информаицю об одном из объектов Cat
    public void printCatInfo(String name){
        for(Cat o: DataBase.catsList){
            if(o.getName().equalsIgnoreCase(name)) {
                System.out.println("Моё имя " + o.getName() + ". Я живу в " + o.getHome());
            }
        }
    }
}