package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import racinggame.utils.FixedNumberGenerator;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    public static final FixedNumberGenerator FIXED_NUMBER_GENERATOR = new FixedNumberGenerator();

    @Before
    public void init() {
        Car.randomNumberProvider = FIXED_NUMBER_GENERATOR;
    }

    @Test
    public void 자동차가_갯수만큼_출전한다() {

        int carNo = 3;
        RacingGame racingGame = new RacingGame(carNo);

        List<Car> cars = racingGame.getCars();

        Assertions.assertThat(cars.size())
                .isEqualTo(carNo);
    }

    @Test
    public void 자동자는_횟수만큼_이동한다() {
        FIXED_NUMBER_GENERATOR.setFixedNumber(4);

        int carNo = 2;

        RacingGame racingGame = new RacingGame(carNo);
        racingGame.racing();
        racingGame.racing();

        List<Car> cars = racingGame.getCars();
        List<Integer> positions = Arrays.asList(cars.get(0).getPosition(), cars.get(1).getPosition());
        Assertions.assertThat(positions).isEqualTo(Arrays.asList(2, 2));
    }

}
