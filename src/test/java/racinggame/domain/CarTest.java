package racinggame.domain;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import racinggame.utils.FixedNumberGenerator;

public class CarTest {

    private Car car;
    public static final FixedNumberGenerator FIXED_NUMBER_GENERATOR = new FixedNumberGenerator();

    @Before
    public void init(){
        car = new Car();
        Car.randomNumberProvider = FIXED_NUMBER_GENERATOR;
    }

    @Test
    public void 자동차의_첫_위치는_0이다() {
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 경계값_미만인_경우_자동차는_정지한다() {

        FIXED_NUMBER_GENERATOR.setFixedNumber(3);

        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 경계값_이상인_경우_자동차는_전진한다() {
        FIXED_NUMBER_GENERATOR.setFixedNumber(4);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 여러번_시도시에도_정상작동한다() {
        // 레이싱카를 초기화한 다음
        FIXED_NUMBER_GENERATOR.setFixedNumber(4);
        car.move();
        FIXED_NUMBER_GENERATOR.setFixedNumber(4);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
        FIXED_NUMBER_GENERATOR.setFixedNumber(3);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(2);

    }




}
