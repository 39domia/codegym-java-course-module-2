public class Display20Prime {
    static boolean CheckPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num == 1) {
            return false;
        }


        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int count = 1;
        int i = 1;
        while (count <= 20) {
            if (CheckPrime(i)) {
                System.out.println(count + " " + i);
                count++;
            }
            i++;
        }
//        System.out.println(CheckPrime(3));

    }
}





