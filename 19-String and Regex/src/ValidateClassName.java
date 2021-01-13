import java.util.regex.Pattern;

public class ValidateClassName {
    private static final Pattern CLASS_NAME_PATTERN = Pattern.compile("^[CAP]\\d{4}[G-M]$");

    public ValidateClassName() {
    }

    public static void main(String[] args) {
        String[] test = {"C0318G", "M0318G", "P0323A"};
        for (String element : test) {
            if (CLASS_NAME_PATTERN.matcher(element).matches()) {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
