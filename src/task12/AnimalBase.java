package task12;

import java.io.*;

import java.util.Scanner;

import static task12.CatService.*;
import static task12.HomeService.link;

public class AnimalBase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в наш приют для котикот :В");
        String commands = "";

        CatService catService = new CatService();
        HomeService homeService = new HomeService();
        FileService fileService = new FileService();

        fileService.creatBasicFile();

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
                    System.out.println("Введите название нового питомника");
                    homeService.newHome(sc.next());
                    break;
                case "2":
                    System.out.println("Введите имя котика и название питомника, в который хотите его добавить");
                    Cat cat = new Cat(sc.next(), sc.next());

                    catService.addAtCatsList(cat); //читаем существующий питомник и заново добавляем всех котов в пустой catsList
                    catsList.add(cat.getName()); //добавляем в catsList нужного кота

                    //заново создаём пустой питомник и по очереди вписываем всех котов из CatsList
                    File file = new File(link + cat.getHome());
                    if(file.exists()){
                        try(FileWriter fw = new FileWriter(file)){
                            for (String s : catsList) {
                                fw.write(s+" ");
                            }
                        }catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }
                        System.out.println("Новый кот успешно добавлен в питомник");
                    }
                    else {
                        System.out.println("Такого питомника не существует");
                    }

                    //Сериализуем котика
                    try(FileOutputStream fos = new FileOutputStream(link2 + cat.getName());
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                        oos.writeObject(cat);
                    }catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Введите имя кота и питомник, откуда он уехал");
                    Cat cat1 = new Cat(sc.next(), sc.next());
                    catService.addAtCatsList(cat1); //читаем существующий питомник и заново добавляем всех котов в пустой СatsList

                    //Создаём пустой питомник и заново заполняем его котами из CatsList, пропуская введёного пользователем кота
                    try(FileWriter fw = new FileWriter(link + cat1.getHome())){
                        for (String s : catsList) {
                            if (cat1.getName().equals(s))
                                continue;
                            else
                                fw.write(s + " ");
                        }
                    }catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "4":
                    System.out.println("Введите название приюта с которого забираем котов, а затем приюта в который добавляем: ");
                    Cat cat2 = new Cat(null, sc.next());
                    Cat cat3 = new Cat(null, sc.next());
                    catService.relocateCats(cat2.getHome(), cat3.getHome());//Читаем всех котов из 1-ого и 2-ого файла и добавляем их catsListRelocate

                    // Заносим в пустой питомник всех котов из catsListRelocates (коты из 1-ого + 2-ого файла)
                    try (FileWriter fw = new FileWriter(link + cat3.getHome());
                         FileWriter fw1 = new FileWriter(link + cat2.getHome())) {
                        for (String s : catsListRelocate) {
                            fw.write(s + " ");
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Коты успешно перенесены");

                    break;
                case "5":
                    System.out.print("Все коты, которые есть у нас в питомниках: ");
                    catService.creatListOfAllCats(); // Создаём список состоящий из всех котов в питомниках и выводим его на экран
                    break;
                case "6":
                    System.out.println("Введите название питомника про который хотите узнать больше");
                    Cat cat4 = new Cat(null, sc.next());
                    catService.addAtCatsList(cat4); //читаем существующий питомник и заново добавляем всех котов в пустой catsList

                    //Читаем catsList и выводим всех котов из питомника
                    for(String s: catsList){
                        System.out.print(s + " ");
                    }
                    break;
                case "7":
                    System.out.println("Введите имя котика о котором хотите получить информацию");
                    String name = sc.next();

                    try (FileInputStream fis = new FileInputStream(link2 + name);
                         ObjectInputStream ois = new ObjectInputStream(fis)){
                        Cat catFromFile = (Cat) ois.readObject();
                        System.out.println("Моё имя " + catFromFile.getName() + ". Я живу в " + catFromFile.getHome());
                    }catch (IOException | ClassNotFoundException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "exit":
                    System.out.println("Программа завершает свою работу. Ждём ваш позже");
                    break;
                default:
                    System.out.println("Извините, сейчас данная команда находиться в разработке");
                    break;
            }

        }

    }

}
