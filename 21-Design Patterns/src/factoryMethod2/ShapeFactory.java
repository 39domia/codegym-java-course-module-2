package factoryMethod2;


public class ShapeFactory {
    public Shape getShape(String type) {
        if ("1".equals(type)) {
            return new Circle();
        } else if ("2".equals(type)) {
            return new Square();
        } else return new Rectangle();
    }
}
