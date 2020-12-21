import java.util.Arrays;

public class Sort {
    public static int random() {
        return (int) ((Math.random() * 10) + 1);
    }

    public static int[] initArr(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random();
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - 1); j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {
        boolean needNextPass = true;
        for (int i = 1; i < arr.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > currentElement; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = currentElement;
        }
        return arr;
    }


    public static void main(String[] args) {
//        int[] arr = initArr(20);
        int[] arr = {6, 1, 2, 3, 7, 5, 4, 8, 9};
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));

    }
}
