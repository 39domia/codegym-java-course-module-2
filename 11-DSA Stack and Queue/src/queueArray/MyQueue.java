package queueArray;

import circularLinkedList.Queue;

public class MyQueue {
    public int capacity;
    public int[] queueArr;
    public int head;
    public int tail;
    public int size;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        return size == capacity;
    }

    public boolean isQueueEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (!isQueueFull()) {
            queueArr[size++] = item;
            head = queueArr[0];
            tail = queueArr[size-1];
        } else
            System.out.println("Queue is full, cant enqueue");
    }

    public int dequeue() {
        if (!isQueueEmpty()) {
            int out = queueArr[0];
            for (int i = 0; i < size - 1; i++) {
                queueArr[i] = queueArr[i + 1];
            }
            queueArr[size - 1] = 0;
            size--;
            head = queueArr[0];
            tail = queueArr[size-1];
            return out;
        } else {
            System.out.println("Queue is empty, cant dequeue");
            return 0;
        }
    }
    public void print(){
        for (int i = 0; i< size;i++){
            System.out.println(queueArr[i]);
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
//        queue.enqueue(6);
//        queue.dequeue();
//        queue.dequeue();
//        queue.print();
        System.out.println(queue.dequeue());
        System.out.println(queue.head);
        System.out.println(queue.tail);
    }


}
