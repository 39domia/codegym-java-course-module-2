package productManagement;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ManagementApp {
    Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Product> map = new HashMap<>();

    static {
        try {
            FileInputStream fileIn = new FileInputStream("data.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (HashMap<Integer, Product>) in.readObject();
//            Product.setAutoId(map.get(map.size()).getId());
        } catch (Exception e) {
            System.out.print("");
        }
    }

    public void showMenu() {
        int choose = -1;
        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("0. Thoát chương trình");
            System.out.println("____________________________________________");
            choose = validateNumberGreaterThan0("Mời nhập:");
            switch (choose) {
                case 1:
                    showProductList();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 0:
                    System.out.println("Cảm ơn đã sử dụng, tạm biệt!");
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void searchProduct() {
        System.out.println("Nhập tên cần tìm");
        String keyword = sc.nextLine();
        for (Product product: map.values()             ) {
            if (product.getName().contains(keyword)){
                System.out.println(product.getName());
            }
        }
    }

    private void addProduct() {
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String manufacturer = sc.nextLine();
        System.out.println("Nhập giá");
        int price = Integer.parseInt(String.valueOf(sc.nextLine()));
        System.out.println("Nhập ghi chú");
        String note = sc.nextLine();
        Product product = new Product(name, manufacturer, price, note);
        map.put(product.getId(), product);
        addFile();
    }

    private void addFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(map);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private String validateName(String mess) {
        System.out.println(mess);
        try{
            String name = sc.nextLine();
            if (name.length() > 25) throw new Exception();
            for (int i = 0; i < name.length(); i++) {
                String str = name.charAt(i) + "";
                if (!str.matches("[a-zA-Z ]")) {
                    throw new Exception();
                }
            }
            name = name.toLowerCase();
            name = name.trim();
            while (name.contains("  ")) {
                name = name.replace("  ", " ");
            }
            String[] str = name.split("");
            str[0] = str[0].toUpperCase();
            StringBuilder nameBuilder = new StringBuilder(str[0]);
            for (int i = 1; i < str.length; i++) {
                if (str[i].equals(" ")) {
                    str[i + 1] = str[i + 1].toUpperCase();
                }
                nameBuilder.append(str[i]);
            }
            return nameBuilder.toString();
        }
        catch (Exception e){
            System.out.println("Chuỗi nhập vào sai định dạng");
            return validateName(mess);
        }

    }

    private void showProductList() {
        System.out.format("||%-3s | ", "ID");
        System.out.format("%-25s | ", "Tên");
        System.out.format("%-20s| ", "Hãng sản xuất");
        System.out.format("%-9s | ", "Giá");
        System.out.format("%-20s || \n", "Ghi chú");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Product product: map.values()         ) {
            System.out.format("||%-3d | ", product.getId());
            System.out.format("%-25s | ", product.getName());
            System.out.format("%-20s| ", product.getManufacturer());
            System.out.format("%-9s| ", product.getPrice());
            System.out.format("%-20s || \n", product.getNote());
        }
    }

    public int validateNumberGreaterThan0(String mess) {
        System.out.println(mess);
        try {
            int num = getInt();
            if (num > -1) {
                return num;
            }
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Nhập vào định dạng sai, mời nhập lại:");
            return validateNumberGreaterThan0(mess);
        }
    }

    public int getInt() {
        return Integer.parseInt(sc.nextLine());
    }


    public static void main(String[] args) {
        ManagementApp app = new ManagementApp();
        app.showMenu();
    }
}
