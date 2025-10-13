package show;

import person.Choreographer;
import person.Director;
import person.MusicAuthor;

public class Ballet extends MusicShow {
    private final Choreographer choreographer;

    public Ballet(String title, int duration, Director director,
                  MusicAuthor musicAuthor, String librettoText, Choreographer choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    @Override
    public String toString() {
        return "Ballet{" + super.toString() +
                ", choreographer{" + choreographer +
                "} ";
    }
}