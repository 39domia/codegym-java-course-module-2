package queueLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedListQueue queue =  new MyLinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.print();

    }
}
