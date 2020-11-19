import java.util.Scanner;

public class NumberText {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println(String.valueOf(input).length());
    }
}