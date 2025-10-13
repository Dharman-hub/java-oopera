import person.Actor;
import person.Choreographer;
import person.Director;
import person.MusicAuthor;
import show.Ballet;
import show.Opera;
import show.Show;

import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Actor actor1 = new Actor("Иван", "Иванов", Sex.MALE.toString(), 28, 182);
        Actor actor2 = new Actor("Анна", "Киселёва", Sex.FEMALE.toString(), 24, 175);
        Actor actor3 = new Actor("Михаил", "Уткин", Sex.MALE.toString(), 25, 190);
        ArrayList<Actor> allActors = new ArrayList<>();
        allActors.add(actor1);
        allActors.add(actor2);
        allActors.add(actor3);

        Director director1 = new Director("Захар", "Запорожцев", Sex.MALE.toString(),
                40, 52);
        Director director2 = new Director("Дмитрий", "Захаров", Sex.MALE.toString(),
                63, 40);
        MusicAuthor musicAuthor = new MusicAuthor("Алексей", "Лебедев", Sex.MALE.toString(),
                50, 34);
        Choreographer choreographer = new Choreographer("Александр", "Лебедев", Sex.MALE.toString(),
                45, 28);

        Show show = new Show("Кабала святош", 120, director1);
        Ballet ballet = new Ballet("Лебединое озеро", 190, director2, musicAuthor,
                Libretto.swanLakeLibretto, choreographer);
        Opera opera = new Opera("Пиковая дама", 235, director2, musicAuthor,
                Libretto.queenOfSpadesLibretto, 50);
        ArrayList<Show> performances = new ArrayList<>();
        performances.add(show);
        performances.add(ballet);
        performances.add(opera);

        ArrayList<String> performancesTitles = new ArrayList<>();
        performancesTitles.add(show.getTitle());
        performancesTitles.add(ballet.getTitle());
        performancesTitles.add(opera.getTitle());

        while (true) {
            printMenu();
            int menuNumber = scanner.nextInt();
            scanner.nextLine();
            switch (menuNumber) {
                case 1:
                    printPerformancesInfo(performances);
                    break;
                case 2:
                    System.out.println("Какого актёра вы хотите добавить?");
                    for (Actor actor: allActors){
                        System.out.println(actor);
                    }
                    System.out.println("Введите имя актёра");
                    String name = scanner.nextLine().strip();
                    System.out.println("Введите фамилию актёра");
                    String secondName = scanner.nextLine().strip();
                    System.out.println("Введите рост актёра");
                    int actorHeight = scanner.nextInt();
                    scanner.nextLine();
                    Actor actor = new Actor(name, secondName, null, 0, actorHeight);
                    System.out.println("В какой спектакль вы хотите добавить актёра?");
                    System.out.println(performancesTitles);
                    String title = scanner.nextLine().strip();
                    switch (title) {
                        case "Кабала святош" -> show.addActor(actor);
                        case "Лебединое озеро" -> ballet.addActor(actor);
                        case "Пиковая дама" -> opera.addActor(actor);
                        default -> System.out.println("Такого спектакля нет");
                    }
                    break;
                case 3:
                    System.out.println("Укажите фамилию актёра, которого вы хотите заменить");
                    String previousActorLastName = scanner.nextLine().strip();
                    System.out.println("Введите имя нового актёра");
                    String newName = scanner.nextLine().strip();
                    System.out.println("Введите фамилию нового актёра");
                    String newSecondName = scanner.nextLine().strip();
                    System.out.println("Введите рост нового актёра");
                    int newActorHeight = scanner.nextInt();
                    scanner.nextLine();
                    Actor newActor = new Actor(newName, newSecondName, null, 0, newActorHeight);
                    System.out.println("В каком спектакле вы хотите заменить актёра?");
                    System.out.println(performancesTitles);
                    String title1 = scanner.nextLine().strip();
                    switch (title1) {
                        case "Кабала святош" -> show.changeActor(newActor, previousActorLastName);
                        case "Лебединое озеро" -> ballet.changeActor(newActor, previousActorLastName);
                        case "Пиковая дама" -> opera.changeActor(newActor, previousActorLastName);
                        default -> System.out.println("Такого спектакля нет");
                    }
                    break;
                case 4:
                    System.out.println("Либретто какого спектакля вы хотите увидеть?");
                    System.out.println(performancesTitles);
                    String title2 = scanner.nextLine().strip();
                    switch (title2) {
                        case "Лебединое озеро" -> ballet.printLibretto();
                        case "Пиковая дама" -> opera.printLibretto();
                        default -> System.out.println("У этого спектакля нет либретто");
                    }
                    break;
                case 5:
                    System.out.println("Информацию о режиссёре какого спектакля вы хотите увидеть?");
                    System.out.println(performancesTitles);
                    String title3 = scanner.nextLine().strip();
                    switch (title3) {
                        case "Кабала святош" -> System.out.println(show.getDirector().toString());
                        case "Лебединое озеро" -> System.out.println(ballet.getDirector().toString());
                        case "Пиковая дама" -> System.out.println(opera.getDirector().toString());
                        default -> System.out.println("Такого спектакля нет");
                    }
                    break;
                case 6:
                    for (Show s: performances) {
                        System.out.println(s.getTitle());
                        if (!s.getPerformanceActors().isEmpty()) {
                            System.out.println(s.getPerformanceActors());
                        } else {
                            System.out.println("Пока что в спектакле никто не участвует");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Такой команды нет");
            }
        }


    }

    public static void printMenu() {
        System.out.println("Какое действие вы хотите совершить?");
        System.out.println("1- Общая информация о спектаклях");
        System.out.println("2- Добавить актёра в спектакль");
        System.out.println("3- Заменить актёра в спектакле");
        System.out.println("4- Вывести либретто оперы или балета");
        System.out.println("5- Вывести информацию о режиссёре спектакля");
        System.out.println("6- Вывести актёров, участвующих в спектаклях");
        System.out.println("0- Выход");
    }

    public static void printPerformancesInfo(ArrayList<Show> performances) {
        for (Show show: performances) {
            System.out.println(show);
            System.out.println();
        }
    }
}
