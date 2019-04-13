import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {
    @Test
    public void null_또는_빈값() {
        Positive expected = new Positive(0);

        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(expected);
        assertThat(StringCalculator.splitAndSum("")).isEqualTo(expected);
    }

    @Test
    public void 값_하나() {
        Positive actual = StringCalculator.splitAndSum("1");
        Positive expected = new Positive(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 쉽표_구분자() {
        Positive actual = StringCalculator.splitAndSum("1,2");
        Positive expected = new Positive(3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 쉼표_콜론_구분자() {
        Positive actual = StringCalculator.splitAndSum("1,2:3");
        Positive expected = new Positive(6);

        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수_예외처리() {
        assertThat(StringCalculator.splitAndSum("-1,2,3"));
    }
}
