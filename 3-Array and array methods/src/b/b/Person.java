package b.b;

public class Person {
    private int age;
    private String name;

    protected Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString1() {
        return "Age: " + age + ", Name: " + name;
    }

    String display() {
        return "abc";
    }
}
