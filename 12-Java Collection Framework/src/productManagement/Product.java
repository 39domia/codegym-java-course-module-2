package productManagement;

import java.util.Comparator;

public class Product {
    private final int id;
    private static int autoID = 0;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.id = ++autoID;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ']';
    }
}

class PriceAscendingSort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
class PriceDescendingSort implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getPrice(), o1.getPrice());
    }
}
