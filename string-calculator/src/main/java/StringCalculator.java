public class StringCalculator {
    public static int splitAndSum(String text) {
        int result = 0;

        if (text == null || text.isEmpty()) {
            return 0;
        } else {
            String[] values = text.split(",|:");
            for (String value : values) {
                result +=Integer.parseInt(value);
            }
        }
        return result;
    }
}
