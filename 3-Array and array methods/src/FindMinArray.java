import java.util.Arrays;
import java.util.Scanner;

public class FindMinArray {
    static int[] createArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i =0; i< arr.length;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static int minValue(int[] arr) {
        int min =arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println(Arrays.toString(arr));
        int min = minValue(arr);
        System.out.println("The smallest element in the array is: " + min);
    }
}
