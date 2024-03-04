package task12;

import task12.cat.*;
import task12.home.homeNew;

import java.util.Scanner;

public class AnimalBase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в наш приют для котикот :В");

        String commands = "";

        while(!commands.equals("exit")){
            System.out.println("\nВ нашей программе доступны следующие команды: " +
                    "\n 1. Добавить новый питомник. \n 2. Добавить нового кота." +
                    "\n 3. Удалить кота. \n 4. Переселить котов из одного питомника в другой." +
                    "\n 5. Посмотреть информацию о всех котах." +
                    "\n 6. Посмотреть информацию о котах в конкретном питомнике." +
                    "\n 7. Посммотреть информацию о конкретном коте." );

            commands = sc.next();

            switch (commands){
                case "1":
                    System.out.println("Введите навание нового приюта: ");
                    homeNew homeNew = new homeNew(sc.next());
                    break;
                case "2":
                    System.out.println("Введите имя нового котика и название его приюта: ");
                    AddCat addCat = new AddCat(sc.next(), sc.next());
                    break;
                case "3":
                    System.out.println("Введите имя котика, который переехал и название его приюта: ");
                    DeleteCat deleteCat = new DeleteCat(sc.next(), sc.next());
                    break;
                case "4":
                    System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
                    RelocateCats relocateCats = new RelocateCats(sc.next(), sc.next());
                    break;
                case "5":
                    System.out.println("Список всех котов: ");
                    ListCats listCats = new ListCats();
                    break;
                case "6":
                    System.out.println("Введите название приюта, про который хотите узнать больше информации: ");
                    AboutHome aboutHome = new AboutHome(sc.next());
                    break;
                case "7":
                    System.out.println("Введите имя котика о котором хотите получить информацию: ");
                    getInfoAboutCat getInfoAboutCat = new getInfoAboutCat(sc.next());
                    break;
                default:
                    System.out.println("Извините, сейчас данная команда находиться в разработке");
            }

        }

    }

}
