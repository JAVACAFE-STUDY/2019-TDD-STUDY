package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(int carNo) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNo; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public static List<Integer> carsPositionList(List<Car> cars) {
        return cars.stream()
                    .map(Car::getPosition)
                    .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void racing() {
        for (Car car : cars) {
            car.move();
        }
    }
}
