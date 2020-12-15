package productManagement;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private int id;
    private static int autoID = 0;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.id = ++autoID;
        this.name = name;
        this.price = price;
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

    @Override
    public int compareTo(Product o) {
        return price - o.getPrice();
    }
}

class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }
}
