package racinggame.domain;

import racinggame.utils.RandomNumberGenerator;
import racinggame.utils.RandomNumberProvider;

public class Car {

    public static final int MOVE_BOUND_VALUE = 4;
    static RandomNumberProvider randomNumberProvider = new RandomNumberGenerator();

    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if(randomNumberProvider.generatedNumber() >= MOVE_BOUND_VALUE)
            position++;
    }
}
