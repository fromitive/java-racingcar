package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        validateCarNameLength(name);
    }

    private void validateCarNameLength(String name) {
        final int MAX_LENGTH = 5;

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }
}
