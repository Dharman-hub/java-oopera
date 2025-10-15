package project.show;

import project.person.Actor;
import project.person.Director;

import java.util.ArrayList;

public class Show {
    protected final String title;
    protected final int duration;
    protected final Director director;
    protected final ArrayList<Actor> performanceActors = new ArrayList<>();

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


    public void addActor(Actor actor) {
        boolean coincidence = false;
        boolean found = false;
        if (performanceActors.isEmpty()) {
            performanceActors.add(actor);
            coincidence = true;
            System.out.println("Актёр добавлен в спектакль!");
        } else {
        for (Actor a: performanceActors) {
            if (a.equals(actor)) {
                found = true;
                break;
            }
        }
        if (!found) {
            performanceActors.add(actor);
            System.out.println("Актёр добавлен в спектакль!");
            coincidence = true;
            }

        }
        if (!coincidence) {
            System.out.println("Такой актёр уже есть в списке");
        }
    }

    public void changeActor(Actor actor, String previousActorLastName){
        ArrayList<Actor> oldActor = new ArrayList<>();
        for (Actor a: performanceActors) {
            if (a.getLastName().equals(previousActorLastName)) {
                oldActor.add(a);
            }
        }
        if (oldActor.isEmpty()) {
            System.out.println("Такого актёра нет в спектакле");
            return;
        }
        if (oldActor.size() > 1) {
            System.out.println("Найдено несколько актёров с этой фамилией. Неизвестно, кого заменить");
            return;
        }
        performanceActors.remove(oldActor.getFirst());
        performanceActors.add(actor);
        System.out.println("Актёр был заменён!");
    }

    public void printAllActors() {
        System.out.println(title);
        if (!performanceActors.isEmpty()) {
            System.out.println(performanceActors);
        } else {
            System.out.println("Пока что в спектакле никто не участвует");
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", director" + director +
                ", performanceActors=" + performanceActors +
                '}';
    }
}