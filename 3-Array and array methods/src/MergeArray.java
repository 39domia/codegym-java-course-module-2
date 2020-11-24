import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    static int[] createArray(String name){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insert size of "+name+" array is: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Insert value for "+name+" array is: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Insert size of arr1 ");
//        int arr1Size = sc.nextInt();
//        int[] arr1 = new int[arr1Size];
//        System.out.println("Insert value for arr1 ");
//        for (int i = 0; i < arr1Size; i++) {
//            arr1[i] = sc.nextInt();
//        }
//
//        System.out.println("Insert size of arr2 ");
//        int arr2Size = sc.nextInt();
//        int[] arr2 = new int[arr2Size];
//        System.out.println("Insert value for arr2 ");
//        for (int i = 0; i < arr2Size; i++) {
//            arr2[i] = sc.nextInt();
//        }

        int[] arr1 = createArray("arr1");
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = createArray("arr2");

        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[arr1.length + arr2.length];
        for(int i = 0; i<arr1.length;i++){
            arr3[i] = arr1[i];
        }

        for(int i = arr1.length; i<arr3.length;i++){
            arr3[i] = arr2[i-arr1.length];
        }
        System.out.println(Arrays.toString(arr3));



    }
}
