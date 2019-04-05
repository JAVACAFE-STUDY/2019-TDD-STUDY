package money;

import java.util.Objects;

public class Dollar extends Money {
    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object object) {
        Money dollar = (Money) object;
        return amount == dollar.amount;
    }

}
