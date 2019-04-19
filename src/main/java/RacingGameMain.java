import racinggame.domain.RacingGame;
import racinggame.ui.ConsoleUI;

public class RacingGameMain {
    public static void main(String[] args) {
        int carNo = ConsoleUI.getCarNo();
        int tryNo = ConsoleUI.getTryNo();

        RacingGame racingGame = new RacingGame(carNo);
        System.out.println("\n실행결과");

        for (int i = 0; i < tryNo; i++) {
            racingGame.racing();
            ConsoleUI.printCarsPosition(racingGame.getCars());
            System.out.println();
        }
    }

}
