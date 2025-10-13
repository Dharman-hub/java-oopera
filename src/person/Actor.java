package person;

import java.util.Objects;

public class Actor extends person.Person {
    protected final int height;

    public Actor(String firstName, String lastName, String sex, int age, int height) {
        super(firstName, lastName, sex, age);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + super.firstName + "', " +
                "lastName='" + super.lastName + "', " +
                "height (" + height + ")" +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor anotherActor = (Actor) o;
        return Objects.equals(firstName, anotherActor.firstName) &&
                Objects.equals(lastName, anotherActor.lastName) &&
                (height == anotherActor.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, height);
    }
}