package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    String name;
    int id;
    int age;

    Employee(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Id: " + this.id);
    }
}

public class ReadData {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        addEmployee();
        addEmployee();

    }

    public static void addEmployee() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("data.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Employee> list = (ArrayList<Employee>) in.readObject();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream objectOutputStream = new FileOutputStream("data.txt");
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(objectOutputStream);

        System.out.println("Enter your name: ");
        String name = reader.readLine();
        System.out.println("Enter your age: ");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Enter your Id: ");
        int id = Integer.parseInt(reader.readLine());
        Employee std = new Employee(name, age, id);

        list.add(std);
        objectOutputStream1.writeObject(list);
        objectOutputStream1.close();
        in.close();

        System.out.println(list.size());
        System.out.println(list);

    }
}