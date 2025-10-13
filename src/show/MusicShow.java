package show;

import person.Director;
import person.MusicAuthor;

public class MusicShow extends Show {
    protected final MusicAuthor musicAuthor;
    protected final String librettoText;

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
                ", director" + super.getDirector() +
                ", performanceActors=" + super.getPerformanceActors();
    }
}