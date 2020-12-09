package circularLinkedList;

public class Queue {
    public Node head;
    public Node tail;
    public final int MAX_VALUE = 5;
    public int size = 0;


    public Queue() {
        head = new Node();
        tail.next = head;
    }

    public boolean isFull() {
        return size == MAX_VALUE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(int data) {
        if (!isFull()) {
            Node newNode = new Node(data);
            if (size == 0) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            tail.next = head;
            size++;
        } else System.out.println("Queue is full, cant enQueue");
    }

    public Node deQueue() {
        Node out = head;
        if (!isEmpty()) {
            head = head.next;
            size--;
            return out;
        } else
            System.out.println("Queue is empty, cant deQueue");
        return null;
    }

    public void displayQueue() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.displayQueue();
        System.out.println(queue.deQueue());
    }
}
