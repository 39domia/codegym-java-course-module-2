package exception;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class IndexOutOfBounds {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[10];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }


    public static void main(String[] args) {
        IndexOutOfBounds arrExample = new IndexOutOfBounds();
        Integer[] arr = arrExample.createRandom();
//        System.out.println(Arrays.toString(arr));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Giá trị của phần tử có chỉ số " + x + " là " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chỉ số vượt quá giới hạn của mảng");
        }
    }
}
