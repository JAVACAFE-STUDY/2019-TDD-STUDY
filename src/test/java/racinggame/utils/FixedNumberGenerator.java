package racinggame.utils;

public class FixedNumberGenerator implements RandomNumberProvider {

    private int fixedNumber;

    public void setFixedNumber(int number) {
        this.fixedNumber = number;
    }

    @Override
    public int generatedNumber() {
        return fixedNumber;
    }
}
