package money;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/* TODO-LIST:
- $5 + 10CHF = $10(환율이 2:1일 경우)
- $5 * 2 = $10
- amount를 private으로 만들기
- Dollar 부작용
- Money 반올림
- equals()
- hashCode()
- Equal null
- Equal object

- 5CHF *2 = 10CHF
- Dollar/Fanc 중복
- 공용 Equals
- 공용 times
- Franc과 Dollar 비교
- 통화?
- testFrancMultiplication 제거
*/
public class MoneyTest {
    Logger logger = LoggerFactory.getLogger("money.MoneyTest");

    @Test
    public void testMultiplication() {
        Money money= Money.dollar(5);
        assertEquals(Money.dollar(15), money.times(3));
        assertEquals(Money.dollar(10), money.times(2));
    }

    @Test
    public void testFrancMultiplication() {
        Money money= Money.franc(5);
        assertEquals(Money.franc(15), money.times(3));
        assertEquals(Money.franc(10), money.times(2));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
}
