package stackQueuePalindrome;

import java.util.Stack;

public class Palindrome {
    public static void stackPalindrome(String str) {
        str = str.toLowerCase();
        String[] arr1 = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr1[i] = String.valueOf(str.charAt(i));
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(arr1[i]);
        }
        String[] arr2 = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr2[i] = stack.pop();
        }
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!arr1[i].equals(arr2[i])) {
                check++;
            }
        }
        if (check > 0) {
            System.out.println("Not palindrome string");
        } else
            System.out.println("Is palindrome string");
    }

    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        stackPalindrome(str);
    }
}
