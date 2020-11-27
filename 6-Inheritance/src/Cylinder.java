public class Cylinder extends Circle2 {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return this.height * Math.PI * getRadius() * getRadius();

    }

    @Override
    public String toString() {
        return " Cylinder{" +
                "height=" + height +
                super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Cylinder cy = new Cylinder(5, "red", 5);
        System.out.println(cy.toString());
    }
}
