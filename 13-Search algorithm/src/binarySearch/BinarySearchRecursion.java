package binarySearch;

public class BinarySearchRecursion {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static void binaryRecursion(int[] list, int low, int high, int key) {
        if (key >= list[0] && key <= list[list.length - 1]) {
            int mid = (low + high) / 2;
            if (key == list[mid]) {
                System.out.println(mid);
                return;
            }
            if (key > list[mid]) {
                low = mid + 1;
            }
            if (key < list[mid]) {
                high = mid - 1;
            }
            if (low > high) {
                System.out.println("Not found");
                return;
            }
            binaryRecursion(list, low, high, key);
        } else {
            System.out.println("Not found");
        }
    }

    public static void main(String[] args) {
        binaryRecursion(list, 0, list.length - 1, 2);
    }
}
