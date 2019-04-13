import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static final String EMPTY_STRING = "";
    public static final String REGEX_CONDITION = ",|:";
    public static final int VALUE_IF_NOT_EXISTS_NUMBER = 0;

    public static Positive splitAndSum(String inputString) {
        if (isExists(inputString)) {
            return new Positive(VALUE_IF_NOT_EXISTS_NUMBER);
        }

        return sum(toInts(split(inputString)));
    }

    private static boolean isExists(String inputString) {
        return inputString == null || inputString.equals(EMPTY_STRING);
    }

    private static String[] split(String input) {
        return input.split(REGEX_CONDITION);
    }

    private static List<Integer> toInts(String[] inputStrings) {
        return Arrays.stream(inputStrings).map(StringCalculator::toInt).collect(Collectors.toList());
    }

    private static int toInt(String inputString) {
        return Integer.parseInt(inputString);
    }

    private static Positive sum(List<Integer> inputValues) {
        Positive number = new Positive();
        for (Integer value : inputValues) {
            number = number.plus(value);
        }

        return number;
    }
}
