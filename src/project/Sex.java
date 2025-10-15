package project;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
