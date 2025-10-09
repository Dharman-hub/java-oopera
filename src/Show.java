import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> performanceActors = new ArrayList<>();

    public ArrayList<Actor> getPerformanceActors() {
        return performanceActors;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }


    public void addActor(ArrayList<Actor> allActors, Scanner scanner) {
        for (Actor actor: allActors){
            System.out.println(actor);
        }
        System.out.println("Введите имя актёра");
        String name = scanner.nextLine().strip();
        System.out.println("Введите фамилию актёра");
        String secondName = scanner.nextLine().strip();
        System.out.println("Введите возраст актёра");
        int actorAge = scanner.nextInt();
        scanner.nextLine();
        Actor actor = new Actor(name, secondName, null, actorAge, 0);
        boolean found = false;
        for (Actor a: allActors) {
            if (a.equals(actor)) {
                performanceActors.add(a);
                System.out.println("Актёр добавлен в спектакль!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Такого актёра нет в списке");
        }
    }

    public void changeActor(Scanner scanner, Show show, ArrayList<Actor> allActors){
        for (Actor actor: allActors){
            System.out.println(actor);
        }
        System.out.println("Укажите имя актёра, которого вы хотите заменить");// я отклоняюсь от тз и провожу доп
        // проверку, тк у людей могут быть одинаковые фамилии (да и вообще в тз ничего не понятно :( )
        String name = scanner.nextLine().strip();
        System.out.println("Укажите фамилию актёра, которого вы хотите заменить");
        String secondName = scanner.nextLine().strip();
        System.out.println("Укажите возраст актёра, которого вы хотите заменить");
        int actorAge = scanner.nextInt();
        scanner.nextLine();
        Actor actor = new Actor(name, secondName, null, actorAge, 0);
        Actor oldActor = null;
        for (Actor a: show.performanceActors) {
            if (a.equals(actor)) {
                oldActor = a;
                break;
            }
        }
        if (oldActor == null) {
            System.out.println("Такого актёра нет в списке");
            return;
        }
        for (Actor a: allActors){
            System.out.println(a);
        }
        System.out.println("Введите имя нового актёра");
        String newName = scanner.nextLine().strip();
        System.out.println("Введите фамилию нового актёра");
        String newSecondName = scanner.nextLine().strip();
        System.out.println("Введите возраст нового актёра");
        int newActorAge = scanner.nextInt();
        scanner.nextLine();
        Actor newActor = null;
        Actor newOneActor = new Actor(newName, newSecondName, null, newActorAge, 0);

        for (Actor a: allActors) {
            if (a.equals(newOneActor)) {
                newActor = a;
                break;
            }
        }
        if (newActor == null) {
            System.out.println("Такого актёра нет в списке");
            return;
        }
        performanceActors.remove(oldActor);
        performanceActors.add(newActor);
        System.out.println("Актёр был заменён!");
    }

    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director=" + director +
                ", performanceActors=" + performanceActors +
                '}';
    }

    public void printAllActors(ArrayList<Actor> actor) {
        for (Actor a: actor) {
            System.out.println(a);
        }
    }
}

class MusicShow extends Show {
    private MusicAuthor musicAuthor;
    private String librettoText;

    public MusicShow(String title, int duration, Director director,
                     MusicAuthor musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println(librettoText);
    }

    @Override
    public String toString() {
        return "title='" + super.getTitle() + '\'' +
                ", duration=" + super.getDuration() +
                ", director=" + super.getDirector() +
                ", performanceActors=" + super.getPerformanceActors();
    }
}

class Ballet extends MusicShow {
    private Choreographer choreographer;

    public Ballet(String title, int duration, Director director,
                  MusicAuthor musicAuthor, String librettoText, Choreographer choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    @Override
    public String toString() {
        return "Ballet{" + super.toString() +
                ", choreographer=" + choreographer +
                "} ";
    }
}

class Opera extends MusicShow {
    private int choirSize;

    public Opera(String title, int duration, Director director, MusicAuthor musicAuthor, String librettoText, int choirSize) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    @Override
    public String toString() {
        return "Opera{" + super.toString() +
                ", choirSize=" + choirSize +
                "} ";
    }
}