package stackLinkerList;

public class GenericStackClient {

    public static void stackOfStrings(){
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
//        stack.pop();
        stack.print();
    }
    public static void stackOfIntegers(){
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        System.out.println(stack.pop());
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.pop();
//        stack.print();

    }

    public static void main(String[] args) {
//        stackOfStrings();
        stackOfIntegers();
    }


}
