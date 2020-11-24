import java.util.Arrays;
import java.util.Scanner;

public class AddValueArray {
    static int CheckExist(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {

                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 0, 0};
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert value that you want to insert ");
        int num = sc.nextInt();
        System.out.println("Insert position ");
        int pos = sc.nextInt();
//        int check = CheckExist(arr, num);
        for (int i = arr.length - 1; i > pos-1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos - 1] = num;
        System.out.println(Arrays.toString(arr));


    }
}
