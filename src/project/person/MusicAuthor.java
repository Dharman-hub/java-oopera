package project.person;

import project.Sex;

public class MusicAuthor extends Person {
    protected final int numberOfCompositions;

    public MusicAuthor(String firstName, String lastName, Sex sex, int age, int numberOfCompositions) {
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