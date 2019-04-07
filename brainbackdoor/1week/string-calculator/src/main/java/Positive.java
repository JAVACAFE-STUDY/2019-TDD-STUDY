public class Positive {
    private int value = 0;

    public Positive() {
    }

    public Positive(int value) {
        if (isMinus(value)) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    private boolean isMinus(int toInt) {
        return toInt < 0;
    }

    public Positive plus(int number) {
        return new Positive(value + number);
    }

    @Override
    public boolean equals(Object o) {
        Positive positive = (Positive) o;
        return value == positive.value;
    }
}
