package productManagement;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private int autoID = 0;
    private String name;
    private String manufacturer;
    private int price;
    private String note;

    public Product(String name, String manufacturer, int price, String note) {
        this.id = ++autoID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.note = note;
    }

    public Product() {
        this.id = ++autoID;

    }

    public int getId() {
        return id;
    }

    public int getAutoID() {
        return autoID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
