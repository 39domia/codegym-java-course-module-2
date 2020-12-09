package stackArray;

public class MyStack {
    private int arr[];
    private int size = 0;

    public MyStack() {
        arr = new int[5];
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else
            return false;
    }

    public boolean isFull() {
        if (this.size == 5) {
            return true;
        } else
            return false;
    }

    public void push(int value) {
        if (!isFull()) {
            arr[size] = value;
            size++;
        } else
            System.out.println("Không thể thêm vào phần tử khi mảng đang đầy");
    }

    public int pop() {
        if (!isEmpty()) {
            int temp = arr[size - 1];
            arr[size - 1] = 0;
            size--;
            return temp;
        } else {
            System.out.println("Không thể lấy ra phần tử trong mảng trống");
            return 0;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.push(13);
        myStack.pop();
        myStack.push(14);
        myStack.push(15);
        myStack.push(15);
        myStack.print();
    }


}
