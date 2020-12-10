package stackBracket;

import java.util.EmptyStackException;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String str = "s * (s – a) * (s – b) * (s – c))";
        Stack<String> stack = new Stack<>();
        try {
            for (int i = 0; i < str.length(); i++) {
                if (String.valueOf(str.charAt(i)).equals("(")) {
                    stack.push("(");
                }
                if (String.valueOf(str.charAt(i)).equals(")")) {
                    stack.pop();
                }
            }
            if (stack.size() > 0) {
                System.out.println("F");
            } else
                System.out.println("T");
        } catch (EmptyStackException e) {
            System.out.println('F');
        }
    }
}
