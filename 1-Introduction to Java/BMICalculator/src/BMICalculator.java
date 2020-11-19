import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert weight (kg)");
        float weight = scanner.nextFloat();
        System.out.println("Insert height (cm)");
        float height = scanner.nextFloat();
        float bmi = weight / ((height / 100) * (height / 100));
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");

        } else if (bmi < 30) {
            System.out.println("Overweight");

        } else {
            System.out.println("Obese");

        }


    }
}
