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
*/
public class MoneyTest {
    Logger logger = LoggerFactory.getLogger("money.MoneyTest");

    @Test
    public void testMultiplication() {
        Dollar five= new Dollar(5);
        assertEquals(new Dollar(15), five.times(3));
        assertEquals(new Dollar(10), five.times(2));
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        assertFalse(new Franc(5).equals(new Dollar(5)));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five= new Franc(5);
        assertEquals(new Franc(15), five.times(3));
        assertEquals(new Franc(10), five.times(2));
    }

}
