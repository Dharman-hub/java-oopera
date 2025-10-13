package person;

public class MusicAuthor extends Person {
    protected final int numberOfCompositions;

    public MusicAuthor(String firstName, String lastName, String sex, int age, int numberOfCompositions) {
        super(firstName, lastName, sex, age);
        this.numberOfCompositions = numberOfCompositions;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfCompositions=" + numberOfCompositions +
                '}';
    }
}