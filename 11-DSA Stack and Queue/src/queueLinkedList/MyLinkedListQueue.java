package queueLinkedList;

public class MyLinkedListQueue {
    private static final int MAX_SIZE = 5;
    public Node head;
    public Node tail;
    public int size = 0;

    public MyLinkedListQueue() {

    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int key) {
        if (!isFull()) {
            Node newNode = new Node(key);
            if (size == 0) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        } else
            System.out.println("Queue is full, can enqueue");
    }

    public Node dequeue() {
        if (!isEmpty()) {
            Node dequeueNode = head;
            head = head.next;
            size--;
            return dequeueNode;
        } else{
            System.out.println("Queue is empty, can dequeue");
            return null;
        }
    }

    public void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.key);
            temp = temp.next;
        }
    }

}
