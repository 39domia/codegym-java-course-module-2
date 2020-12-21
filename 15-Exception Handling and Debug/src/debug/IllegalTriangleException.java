package debug;

class Triangle {
    protected double side1 = 1.0;
    protected double side2 = 1.0;
    protected double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 >= side2 + side3)
            throw new IllegalTriangleException("Canh 1 khong duoc lon hon");
        else if (side2 >= side1 + side3)
            throw new IllegalTriangleException("Canh 2 khong duoc lon hon");
        else if (side3 >= side2 + side1)
            throw new IllegalTriangleException("Canh 3 khong duoc lon hon");
        else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }


    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String toString() {
        return "Triangle side 1 = " + side1 + ", side 2 = " + side2 + ", side 3 = " + side3;
    }
}

public class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(5, 6, 12);
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }
    }
}
