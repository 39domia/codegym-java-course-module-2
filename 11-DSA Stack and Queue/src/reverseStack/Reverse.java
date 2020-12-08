package reverseStack;

import java.util.Arrays;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            stack.push(j);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arr));
    }


}
