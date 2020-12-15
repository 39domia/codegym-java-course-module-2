package productManagement;

import java.util.ArrayList;
import java.util.Collections;
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
                case 'a':
                    addProduct();
                    break;
                case 'e':
                    editProduct();
                    break;
                case 'd':
                    deleteProduct();
                    break;
                case 'h':
                    showAllProduct();
                    break;
                case 's':
                    searchProducts();
                    break;
                case 'o':
                    sortProduct();
                    break;
                case 'x':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong select");
                    break;
            }
        }
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
        } else{
            System.out.println("List product empty.");
            System.out.println("==============================");
        }

    }

    public void editProduct() {
        System.out.println("Edit product information by ID");
        System.out.println("Enter product ID:");
        int id = getInteger();
        System.out.println("Product selected:");
        System.out.println(productList.get(id - 1));
        System.out.println("Enter new name:");
        String newName = getString();
        System.out.println("Enter new price");
        int newPrice = getInteger();
        productList.get(id - 1).setName(newName);
        productList.get(id - 1).setPrice(newPrice);
        System.out.println("Edit done.");
        System.out.println("==============================");
    }

    public void deleteProduct() {
        System.out.println("Delete product by ID");
        System.out.println("Enter product ID:");
        int id = getInteger();
        System.out.println("Product selected:");
        System.out.println(productList.get(id - 1));
        productList.remove(id - 1);
        System.out.println("Delete done.");
        System.out.println("==============================");
    }

    public void searchProducts() {
        System.out.println("Enter name product:");
        String nameSearch = getString();
        System.out.println("Search result:");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(nameSearch)) {
                System.out.println(productList.get(i));
            }
        }
        System.out.println("Search done.");
        System.out.println("==============================");
    }

    public void sortProduct(){
        System.out.println("Sorted Ascending");
        Collections.sort(productList);
        showAllProduct();
        System.out.println("Sort done.");
        System.out.println("==============================");

        System.out.println("Sorted Descending ");
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(productList,priceComparator);
        for(Product st : productList){
            System.out.println(st.toString());
        }
        System.out.println("Sort done.");
        System.out.println("==============================");
    }
}
