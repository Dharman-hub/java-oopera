package project.person;

import project.Sex;

public class Director extends Person {
    protected final int numberOfShows;

    public Director(String firstName, String lastName, Sex sex, int age, int numberOfShows) {
        super(firstName, lastName, sex, age);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return  "{firstName='" + super.firstName + "', " +
                "lastName='" + super.lastName + "', " +
                "numberOfShows=" + numberOfShows +
                '}';
    }
}