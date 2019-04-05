public class StringCalculator {
    public static int splitAndSum(String text) {
        int result = 0;

        if(text == null || text.isEmpty()) {
            return 0;
        }else{
            result =  Integer.parseInt(text);
        }
        return result;
    }
}
