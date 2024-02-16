package racingcar.model;

import racingcar.controller.NumericGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Cars {
    private NumericGenerator generator;
    private List<Car> cars;

    public Cars(NumericGenerator generator, String input) {
        this.generator = generator;

        isValidInput(input);
        List<String> carNames = parseWithComma(input);

        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void isValidInput(String input) {
        final String REGEX_VALID_INPUT_CHECK = "^[^,]+(,[^,]+)*$";
        Pattern pattern = Pattern.compile(REGEX_VALID_INPUT_CHECK);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 문자열의 형태가 유효하지 않습니다.");
        }
    }

    public List<String> parseWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

    public void moveCars() {
        final int MINIMUM_MOVE_NUMBER = 4;

        for (Car car : cars) {
            if (generator.generate() >= MINIMUM_MOVE_NUMBER) {
                car.move();
            }
        }
    }

    public String calculateWinner() {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
