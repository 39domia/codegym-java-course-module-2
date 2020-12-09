package circularLinkedList;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "" + data;

    }
}
