package project.person;

import project.Sex;
import java.util.Objects;

public class Person {
    protected final String firstName;
    protected final String lastName;
    protected final Sex sex;
    protected int age;

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String lastName, Sex sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person anotherActor = (Person) o;
        return Objects.equals(firstName, anotherActor.firstName) &&
                Objects.equals(lastName, anotherActor.lastName) &&
                (age == anotherActor.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}