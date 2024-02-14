package racingcar.controller.numericgenerator;

import racingcar.controller.NumericGenerator;

import java.util.Random;

public class RandomNumericGenerator implements NumericGenerator {

    public Random random = new Random();
    @Override
    public int generate() {
        return random.nextInt(10);
    }
}