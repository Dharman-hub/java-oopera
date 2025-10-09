import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;

    public Person(String firstName, String lastName, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public void setAge(int age) {
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
        if (Objects.equals(firstName, anotherActor.firstName) &&
                Objects.equals(lastName, anotherActor.lastName) &&
                (age == anotherActor.age)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}


class Actor extends Person {
    private int height;

    public Actor(String firstName, String lastName, String sex, int age, int height) {
        super(firstName, lastName, sex, age);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Actor{" +
                super.toString() +
                ", height=" + height +
                '}';

    }
}


class Director extends Person {
    private int numberOfShows;

    public Director(String firstName, String lastName, String sex, int age, int numberOfShows) {
        super(firstName, lastName, sex, age);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return "Director{" +
                super.toString() +
                ", numberOfShows=" + numberOfShows +
                '}';
    }
}

class Choreographer extends Person {
    private int numberOfProduction;

    public Choreographer(String firstName, String lastName, String sex, int age, int numberOfProduction) {
        super(firstName, lastName, sex, age);
        this.numberOfProduction = numberOfProduction;
    }

    @Override
    public String toString() {
        return "Choreographer{" +
                super.toString() +
                ", numberOfProduction=" + numberOfProduction +
                '}';
    }
}
class MusicAuthor extends Person {
    private int numberOfCompositions;

    public MusicAuthor(String firstName, String lastName, String sex, int age, int numberOfCompositions) {
        super(firstName, lastName, sex, age);
        this.numberOfCompositions = numberOfCompositions;
    }

    @Override
    public String toString() {
        return "MusicAuthor{" +
                super.toString() +
                ", numberOfCompositions=" + numberOfCompositions +
                '}';
    }
}