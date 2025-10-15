package project.show;

import project.person.Director;
import project.person.MusicAuthor;

public class Opera extends MusicShow {
    protected final int choirSize;

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