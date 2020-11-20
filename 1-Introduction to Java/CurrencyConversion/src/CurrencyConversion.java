import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        int usd = 23000;
        int vnd;
        System.out.println("PLz enter a VND money");
        Scanner sc = new Scanner(System.in);
        vnd = sc.nextInt();
        System.out.println("USD: " + vnd*usd);
    }


}
