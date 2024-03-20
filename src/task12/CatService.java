package task12;

import java.util.HashSet;
import java.util.List;

public class CatService {

    private List<Cat> catList = DataBase.getDataBase().getCatList();
    private HashSet<String> homeList = DataBase.getDataBase().getHomeList();

    public void movingCat(Cat cat) {
        //Убирет кота из списка catsList
        if ((homeList.contains(cat.getHome())) && (catList.contains(cat))) {
            for (Cat cat1 : catList) {
                if (cat1.equals(cat) ) {
                    catList.remove(cat1);
                    break;
                }
            }
        } else {
            System.out.println("Такого кота или питоника не существует!");
        }
    }

    //Переносит котов из одного питомника в другой
    public void relocateCats(String homeSource, String homeTarget) {
        if (!homeList.contains(homeSource) || !homeList.contains(homeTarget)) {
            for (Cat cat : catList) {
                if (homeSource.equalsIgnoreCase(cat.getHome())) {
                    cat.setName(homeTarget);
                }
            }
        } else {
            System.out.println("Одного из питомников не существует");
        }
    }

    //Выводит всех котов из списка catsList
    public void printAllCats() {
        for (Cat cat : catList) {
            System.out.print(cat.getName() + " ");
        }
    }

    //Выводит информаицю об одном из объектов Cat
    public void printCatInfo(String name) {
        for (Cat cat : catList) {
            if (cat.getName().equalsIgnoreCase(name)) {
                System.out.println("Моё имя " + cat.getName() + ". Я живу в " + cat.getHome());
            }
        }
    }

    public void addNewCat(Cat cat){
        if (homeList.contains(cat.getHome())) {
            catList.add(cat);
        } else {
            System.out.println("Такой питомника не существует");
        }
    }

    public Cat getCat(String catName, String catHome){
        return new Cat(catName, catHome);
    }
}