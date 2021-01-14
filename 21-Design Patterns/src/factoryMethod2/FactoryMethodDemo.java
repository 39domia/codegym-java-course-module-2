package factoryMethod2;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("1");
        System.out.println("Shape 1 draw: "); shape1.draw();
        Shape shape2 = factory.getShape("2");
        System.out.println("Shape 2 draw: "); shape2.draw();
        Shape shape3 = factory.getShape("3");
        System.out.println("Shape 3 draw: "); shape3.draw();
    }
}
