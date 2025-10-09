import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // По ТЗ создаю спектакли и рабочий состав в main
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
                    printPerformancesAndPeople(performances);
                    break;
                case 2:
                    System.out.println("В какой спектакль вы хотите добавить актёра?");
                    System.out.println(performancesTitles);
                    String title = scanner.nextLine().strip();
                    switch (title) {
                        case "Кабала святош" -> show.addActor(allActors, scanner);
                        case "Лебединое озеро" -> ballet.addActor(allActors, scanner);
                        case "Пиковая дама" -> opera.addActor(allActors, scanner);
                        default -> System.out.println("Такого спектакля нет");
                    }
                    break;
                case 3:
                    System.out.println("В каком спектакле вы хотите заменить актёра?");
                    System.out.println(performancesTitles);
                    String title1 = scanner.nextLine().strip();
                    switch (title1) {
                        case "Кабала святош" -> show.changeActor(scanner, show, allActors);
                        case "Лебединое озеро" -> ballet.changeActor(scanner, ballet, allActors);
                        case "Пиковая дама" -> opera.changeActor(scanner, opera, allActors);
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
        System.out.println("1- Вывести список спектаклей и участвующий персонал");
        System.out.println("2- Добавить актёра в спектакль");
        System.out.println("3- Заменить актёра в спектакле");
        System.out.println("4- Вывести либретто оперы или балета");
        System.out.println("0- Выход");
    }

    public static void printPerformancesAndPeople(ArrayList<Show> performances) {
        for (Show show: performances) {
            System.out.println(show);
            System.out.println();
        }
    }
}
// Надеюсь, что код приличный :)