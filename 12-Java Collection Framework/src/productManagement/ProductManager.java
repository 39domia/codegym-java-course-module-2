package productManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public String getString() {
        return sc.nextLine();
    }

    public int getInteger() {
        return Integer.parseInt(sc.nextLine());
    }

    public char getChar() {
        return sc.nextLine().charAt(0);
    }

    public void menu() {
        char choise = 'a';
        while (choise != 'x') {
            System.out.println("Menu");
            System.out.println("(A)dd products");
            System.out.println("(E)dit a product");
            System.out.println("(D)elete a product");
            System.out.println("S(h)ow all products");
            System.out.println("(S)earch a product by name");
            System.out.println("S(o)rt");
            System.out.println("E(x)it");
            choise = getChar();
            switch (choise) {
                case 'a' -> addProduct();
                case 'e' -> editProduct();
                case 'd' -> deleteProduct();
                case 'h' -> showAllProduct();
                case 's' -> searchProducts();
                case 'o' -> sortProduct();
                case 'x' -> System.out.println("Exiting...");
                default -> System.out.println("Wrong select");
            }
        }
    }

    public int indexOf(ArrayList<Product> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(ArrayList<Product> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public void addProduct() {
        System.out.println("Insert the number of products");
        int number = getInteger();
        for (int i = 0; i < number; i++) {
            System.out.println("Insert name of product " + (i + 1));
            String name = sc.nextLine();
            System.out.println("Insert price of product " + (i + 1));
            int price = getInteger();
            productList.add(new Product(name, price));
        }
        System.out.println("Add done.");
        System.out.println("==============================");
    }

    public void showAllProduct() {
        if (productList.size() > 0) {
            for (Product product : productList) {
                System.out.println(product);
            }
        } else {
            System.out.println("List product empty.");
            System.out.println("==============================");
        }
    }

    public void editProduct() {
        System.out.println("Edit product information by ID");
        System.out.println("Enter product ID:");
        int id = getInteger();
        System.out.println("Product selected:");
        int indexOf = indexOf(productList, id);
        if (indexOf != -1) {
            System.out.println(productList.get(indexOf));
            System.out.println("Enter new name:");
            String newName = getString();
            System.out.println("Enter new price");
            int newPrice = getInteger();
            productList.get(indexOf).setName(newName);
            productList.get(indexOf).setPrice(newPrice);
            System.out.println("Edit done.");
        } else System.out.println("Not found");
        System.out.println("==============================");
    }


    public void deleteProduct() {
        System.out.println("Delete product by ID");
        System.out.println("Enter product ID:");
        int id = getInteger();
        System.out.println("Product selected:");
        int indexOf = indexOf(productList, id);
        if (indexOf != -1) {
            System.out.println(productList.get(indexOf));
            productList.remove(indexOf);
            System.out.println("Delete done.");

        } else System.out.println("Not found");
        System.out.println("==============================");
    }

    public void searchProducts() {
        System.out.println("Enter name product:");
        String nameSearch = getString();
        System.out.println("Search result:");
        int indexOf = indexOf(productList, nameSearch);
        if (indexOf != -1) {
            System.out.println(productList.get(indexOf));
            System.out.println("Search done.");
        } else System.out.println("Not found");
        System.out.println("==============================");
    }

    public void sortProduct() {
        System.out.println("Sorted Ascending");
        PriceAscendingSort ascendingSort = new PriceAscendingSort();
        productList.sort(ascendingSort);
        for (Product st : productList) {
            System.out.println(st.toString());
        }
        System.out.println("Sort done.");
        System.out.println("==============================");

        System.out.println("Sorted Descending ");
        PriceDescendingSort descendingSort = new PriceDescendingSort();
        productList.sort(descendingSort);
        for (Product st :
                productList) {
            System.out.println(st.toString());
        }
        System.out.println("Sort done.");
        System.out.println("==============================");
    }
}
