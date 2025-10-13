package person;

public class Choreographer extends Person {
    protected final int numberOfProduction;

    public Choreographer(String firstName, String lastName, String sex, int age, int numberOfProduction) {
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