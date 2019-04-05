package money;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/* TODO-LIST:
- $5 + 10CHF = $10(환율이 2:1일 경우)
- $5 * 2 = $10
*/
public class MoneyTest {

    @Test
    public void testMultiplication() {
        Dollar five= new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}
