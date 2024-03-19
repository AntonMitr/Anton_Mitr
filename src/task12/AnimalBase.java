package task12;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AnimalBase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в наш приют для котикот :В");
        String commands = "";

        HomeService homeService = new HomeService();
        CatService catService = new CatService();

        while(!commands.equals("exit")){
            System.out.println("\nВ нашей программе доступны следующие команды: " +
                    "\n 1. Добавить новый питомник. \n 2. Добавить нового кота." +
                    "\n 3. Удалить кота. \n 4. Переселить котов из одного питомника в другой." +
                    "\n 5. Посмотреть информацию о всех котах." +
                    "\n 6. Посмотреть информацию о котах в конкретном питомнике." +
                    "\n 7. Посммотреть информацию о конкретном коте." +
                    "\n 8. Посммотреть информацию о всех питомниках." );

            commands = sc.next();

            DataBase.getProgramLogger();

            switch (commands){
                case "1":
                    System.out.println("Введите название нового питомника");
                    homeService.creatNewHome(sc.next());
                    break;

                case "2":
                    System.out.println("Введите имя котика и название питомника, в который хотите его добавить");
                    Cat cat = new Cat(sc.next(), sc.next());

                    //Добавляет нового кота в список catsList
                    if (DataBase.homesList.contains(cat.getHome())) {
                        DataBase.catsList.add(cat);
                    } else {
                        System.out.println("Такой питомника не существует");
                    }
                    break;

                case "3":
                    System.out.println("Введите имя кота и питомник, откуда он уехал");
                    Cat cat1 = new Cat(sc.next(), sc.next());
                    catService.movingCat(cat1);
                    break;

                case "4":
                    System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
                    String homeSource = sc.next();
                    String homeTarget = sc.next();
                    catService.relocateCats(homeSource, homeTarget);
                    break;

                case "5":
                    System.out.print("Все коты, которые есть у нас в питомниках: \n");
                    catService.printAllCats();
                    break;

                case "6":
                    System.out.println("Введите название питомника про который хотите узнать больше");
                    String home = sc.next();
                    System.out.println("Все коты проживающие в питомнике: ");
                    homeService.printCatsAtHome(home);
                    break;

                case "7":
                    System.out.println("Введите имя котика о котором хотите получить информацию");
                    String name = sc.next();
                    catService.printCatInfo(name);
                    break;

                case "8":
                    System.out.print("Все питомники, которые есть у нас в базе: \n");
                    homeService.printAllHomes();
                    break;

                case "exit":
                    DataBase.getProgramLogger().serialization();
                    System.out.println("Программа завершает свою работу. Ждём ваш позже");
                    break;
                default:
                    System.out.println("Извините, сейчас данная команда находиться в разработке");
                    break;
            }

        }

    }

}
