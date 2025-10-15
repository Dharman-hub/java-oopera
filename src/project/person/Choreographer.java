package project.person;

import project.Sex;

public class Choreographer extends Person {
    protected final int numberOfProduction;

    public Choreographer(String firstName, String lastName, Sex sex, int age, int numberOfProduction) {
        super(firstName, lastName, sex, age);
        this.numberOfProduction = numberOfProduction;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfProduction=" + numberOfProduction +
                '}';
    }
}