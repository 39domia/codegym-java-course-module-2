public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return ((this.b * this.b) - (4 * this.a * this.c));
    }

    public double getRoot1() {
        return (((-this.b) + (Math.sqrt((this.b * this.b) - (4 * this.a * this.c)))) / (2 * this.a));
    }

    public double getRoot2() {
        return (((-this.b) - (Math.sqrt((this.b * this.b) - (4 * this.a * this.c)))) / (2 * this.a));
    }

    public static void main(String[] args) {
        QuadraticEquation qe = new QuadraticEquation(2, 4, 0);
        double check = qe.getDiscriminant();
        if (check >= 0) {
            System.out.println("Solution 1: " + qe.getRoot1());
            System.out.println("Solution 1: " + qe.getRoot2());
        } else {
            System.out.println("No solutions");
        }

    }
}
