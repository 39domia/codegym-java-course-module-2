package BST.codeGym;

public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(30);
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}