public class Positive {
    private int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int number){
        if(number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Positive add(Positive other) {
        return new Positive(this.number + other.number);
    }

    public int getNumber() {
        return number;
    }
}
