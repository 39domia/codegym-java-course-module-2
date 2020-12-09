package binary;

import java.util.ArrayList;
import java.util.Stack;

public class Binary {
    public static void decToBinary(int num) {
        Stack<Integer> stack = new Stack<>();
        final int BINARY = 2;
        while (num != 0) {
            stack.push(num % BINARY);
            num = num / BINARY;
        }
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void binaryToDec(int num) {
        String str = "" + num;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(2, str.length() - (i + 1));
        }
        System.out.println(result);
    }

    public static void decToHex(int num) {
        Stack<Integer> stack = new Stack<>();
        String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        final int HEX = 16;
        while (num != 0) {
            stack.push(num % HEX);
            num = num / HEX;
        }
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            System.out.print(arr[stack.pop()]);
        }
        System.out.println();
    }

    public static void hexToDec(String num) {
        String str = "" + num;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        int result = 0;
        int[] arr2 = new int[str.length()];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arrayList.indexOf(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < str.length(); i++) {
            result += arr2[i] * Math.pow(16, str.length() - (i + 1));
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        decToBinary(11);
        binaryToDec(1011);
        decToHex(700);
        hexToDec("2BC");
    }
}


