import java.util.Arrays;
import java.util.Scanner;

public class FindMax2DArray {
    static int[][] create2DArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row of array ");
        int row = sc.nextInt();
        System.out.println("Enter column of array ");
        int column = sc.nextInt();
        int arr[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("Array at [" + i + "] [" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;

    }

    static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = create2DArray();
        int max = findMax(arr);

        System.out.println(Arrays.deepToString(arr));
        System.out.println(max);
    }
}
