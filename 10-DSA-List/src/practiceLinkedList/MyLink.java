package practiceLinkedList;

public class MyLink {
    private Node head;
    private int numNode = 0;

    public MyLink(Object data) {
        head = new Node(data);
        this.numNode = 1;
    }

    public MyLink() {
    }

    public void add(int index, Object data) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.getNext() != null; i++) {
            temp = temp.getNext();
        }
        Node hold = temp.getNext();
        temp.setNext(new Node(data));
        temp.getNext().setNext(hold);
        numNode++;

    }

    public int indexOf(Object element){
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if(temp.getData() == element){
                return i;
            }

            temp = temp.getNext();
        }
        return -1;
    }

    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node hold = temp.getNext().getNext();
        temp.setNext(hold);
        numNode--;
    }
    public void remove(Object element) {
        Node temp = head;
        for (int i = 0; i < indexOf(element)-1; i++) {
            temp = temp.getNext();
        }
        Node hold = temp.getNext().getNext();
        temp.setNext(hold);
        numNode--;
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public int size(){
        return numNode;
    }

    public void addFirst(Object element){
        Node temp = head;
        head = new Node(element);
        head.setNext(temp);
        numNode++;
    }

    public void addLast(Object element){
        Node temp = head;
        for (int i = 0; i < numNode - 1; i++) {
            temp = temp.getNext();
        }
        Node node = new Node(element);
        temp.setNext(node);
        numNode++;
    }

    public void clear(){
        head.setData(null);
        head.setNext(null);
        numNode=0;
    }

    public static void main(String[] args) {
        MyLink myList = new MyLink("1");
        myList.add(1, "2");
        myList.add(2, "3");
        myList.add(3, "4");
        myList.addLast("5");
        myList.remove("3");
        myList.clear();
        myList.print();
//        System.out.println("size: "+ myList.size());
    }
}
