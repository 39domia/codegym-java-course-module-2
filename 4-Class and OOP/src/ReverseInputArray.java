
import java.util.Scanner;

public class Laptop {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = array.length-1; j >= 0; j--) {
            System.out.print(array[j] + "\t");
        }


    }


}



