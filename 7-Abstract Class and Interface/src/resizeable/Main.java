package resizeable;

public class Main {
    public static void main(String[] args) {
        double randomNum =  Math.floor(((Math.random() *100)));
        Circle circle = new Circle(3.4);
        Square square = new Square(10);
        Rectangle rectangle = new Rectangle(4, 4);
//        circle.resize(randomNum);
//        square.resize(randomNum);
        System.out.println(rectangle.getLength());
        System.out.println(randomNum);
        rectangle.resize(randomNum);
    }
}
