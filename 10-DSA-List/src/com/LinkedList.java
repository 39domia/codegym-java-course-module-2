package com;

public class LinkedList {
    private Node head;
    private int numNodes;

    public LinkedList(Object data) {
        head = new Node(data);
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;

        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;

    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    public void edit(int index, Object data) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        temp.setData(data);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList(99);
        ll.addFirst(15);
        ll.addFirst(14);
        ll.addFirst(13);
        ll.addFirst(12);
        ll.addFirst(11);
        ll.addFirst(10);

//        ll.add(1,9);
//        ll.add(4,9);
        ll.edit(1, 98);
//        ll.remove(2);
        ll.printList();
    }
}
