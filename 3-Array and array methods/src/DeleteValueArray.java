import java.util.Arrays;
import java.util.Scanner;

public class DeleteValueArray {
    static int CheckExist(int[] arr, int num) {
        for (int i =0;i<arr.length;i++) {
            if(arr[i] == num){

                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert value that you want to delete ");
        int num  = sc.nextInt();
        int check = CheckExist(arr, num);
        if(check !=-1){
            for (int i =check; i< arr.length-1;i++){
                arr[i] = arr[i +1];
            }
            arr[arr.length-1] = 0;

        }
        System.out.println(Arrays.toString(arr));

    }
}
