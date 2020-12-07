package practice;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
//        myList.clear();
        myList.remove(2);
        myList.add(2, 3);
        myList.print();
    }
}
