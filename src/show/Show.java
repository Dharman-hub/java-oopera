package show;

import person.Actor;
import person.Director;

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
        boolean found = false;
        if (performanceActors.isEmpty()) {
            performanceActors.add(actor);
            found = true;
            System.out.println("Актёр добавлен в спектакль!");
        }else{
        for (Actor a: performanceActors) {
            if (!a.equals(actor)) {
                performanceActors.add(actor);
                System.out.println("Актёр добавлен в спектакль!");
                found = true;
                break;
            }
        }
        }
        if (!found) {
            System.out.println("Такой актёр уже есть в списке");
        }
    }

    public void changeActor(Actor actor, String previousActorLastName){
        Actor oldActor = null;
        for (Actor a: performanceActors) {
            if (a.getLastName().equals(previousActorLastName)) {
                oldActor = a;
                break;
            }
        }
        if (oldActor == null) {
            System.out.println("Такого актёра нет в спектакле");
            return;
        }
        performanceActors.remove(oldActor);
        performanceActors.add(actor);
        System.out.println("Актёр был заменён!");
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