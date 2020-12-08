package stackLinkerList;

import java.util.LinkedList;

public class MyGenericStack<T> {
    public LinkedList<T> stack;
    private final int MAX_SIZE = 5;
    public MyGenericStack() {
        stack = new LinkedList<>();
    }
    public int size() {
        return stack.size();
    }

    public boolean isFull(){
        if (size() == MAX_SIZE){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }


    public void push(T element) {
        if (!isFull()){
            stack.addLast(element);

        }
        else {
            System.out.println("Stack is full, cant push");
        }
    }
    public T pop() {
        if(!isEmpty()){
            return stack.removeLast();
        }
        else {
            System.out.println("Stack is empty, cant pop");
            return null;
        }

    }

    public void print(){
        for (int i = 0; i< size(); i++){
            System.out.println(stack.get(i));
        }
    }




}
