public class StringCalculator {
    public static int splitAndSum(String text) {
        int result = 0;

        if (text == null || text.isEmpty()) {
            return 0;
        } else {
            String[] values = text.split(",|:");
            result = getResult(values);
        }
        return result;
    }

    private static int getResult(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
