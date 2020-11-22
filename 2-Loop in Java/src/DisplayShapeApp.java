import java.util.Scanner;

public class DisplayShapeApp {
    public static void main(String[] args) {
        int choise = -1;
        Scanner sc = new Scanner(System.in);
        while (choise != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle ");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");

            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            System.out.print("*");
                        }
                        System.out.println("*");
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("*");
                    }
                    break;
                case 3:
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("*");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong chooise");
            }
        }

    }
}
