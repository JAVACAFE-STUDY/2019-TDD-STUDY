public class StringCalculator {
    public static int splitAndSum(String text) {
        int result = 0;

        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] values = text.split(",|:");
        result = sum(values);
        return result;
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
