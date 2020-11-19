import java.util.Scanner;

public class NumberText {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (String.valueOf(number).length()){
            case 1 -> {
                switch (number) {
                    case 1 -> System.out.println("one");
                    case 2 -> System.out.println("two");
                    case 3 -> System.out.println("three");
                    case 4 -> System.out.println("four");
                    case 5 -> System.out.println("five");
                    case 6 -> System.out.println("six");
                    case 7 -> System.out.println("seven");
                    case 8 -> System.out.println("eight");
                    case 9 -> System.out.println("night");
                    default -> System.out.println("out of ability");
                }
            }
            case 2 -> System.out.println("a");
        }


        System.out.println(String.valueOf(number).length());
    }
}