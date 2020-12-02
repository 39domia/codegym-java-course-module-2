package com;

import java.util.Arrays;
import java.util.Scanner;

public class Drinks {
    private String name;
    private String type;

    public Drinks() {
    }

    public Drinks(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void menu() {
        int choose = -1;
        Scanner sc = new Scanner(System.in);
        while (choose != 2) {
            System.out.println("MENU");
            System.out.println("1. Mua thức uống");
            System.out.println("2. Thoát chương trình");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    for (int i = 0; i < setDrinks().length; i++) {
                        System.out.println(setDrinks()[i]);
                    }
                    break;
                case 2:
                    System.out.println("Đang thoát...");
                    break;
                default:
                    System.out.println("Bạn đã chọn sai");
                    break;
            }
        }
    }

    public Drinks[] setDrinks() {
        return new Drinks[]{
                new Drinks("Trà sữa trân châu", "Trà sữa"),
                new Drinks("Trà sữa chocolate", "Trà sữa"),
                new Drinks("Cà phê sữa", "Cà phê"),
                new Drinks("Cà phê đen", "Cà phê"),
        };

//        Drinks traSua1 = new Drinks("Trà sữa trân châu", "Trà sữa");
//        Drinks traSua2 = new Drinks("Trà sữa chocolate", "Trà sữa");
    }

    public static void main(String[] args) {
        Drinks drinks = new Drinks();
        drinks.menu();
    }
}
