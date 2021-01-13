import java.util.regex.Pattern;

public class ValidateTelephoneNumber {
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("^\\(\\d{1,2}\\)-\\(0\\d{9}\\)$");

    public static void main(String[] args) {
        String[] test = {"(84)-(0978489648)", "(a8)-(22222222)"};
        for (String element : test) {
            if (TELEPHONE_PATTERN.matcher(element).matches()) {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
