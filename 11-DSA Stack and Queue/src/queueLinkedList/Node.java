package queueLinkedList;

public class Node {
    public int key;
    public Node next;

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return ""+ key;
    }

}
