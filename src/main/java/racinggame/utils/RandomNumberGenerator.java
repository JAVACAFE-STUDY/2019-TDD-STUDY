package racinggame.utils;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumberProvider {

    @Override
    public int generatedNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
