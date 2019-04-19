package racinggame.ui;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    static Scanner scanner = new Scanner(System.in);

    public static void printCarsPosition(List<Car> cars) {
        RacingGame.carsPositionList(cars)
                .forEach(ConsoleUI::visiblePosition);
    }

    private static void visiblePosition(Integer position) {
        String visiblePosition = new String(new char[position]).replace("\0", "-");
        System.out.println(visiblePosition);
    }

    public static int getCarNo() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int getTryNo() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
