public class FizzBuzz {
    public static String FizzBuzzTranslate(int number) {
        if (number <= 0) return "invalid";
        String str = ""+number;
        String[] arr = str.split("");
        for (String s : arr) {
            if (s.equals("3")) {
                return "Fizz";
            }
            if (s.equals("5")) {
                return "Buzz";
            }
        }
        String[][] arr2 = {
                {"1", " mot"},
                {"2", " hai"},
                {"3", " ba"},
                {"4", " bon"},
                {"5", " nam"},
                {"6", " sau"},
                {"7", " bay"},
                {"8", " tam"},
                {"9", " chin"},
        };
        StringBuilder result = new StringBuilder();
        for (String[] strings : arr2) {
            if (arr[0].equals(strings[0])) {
                result.append(strings[1]);
            }
        }
        for (String[] strings : arr2) {
            if (arr[1].equals(strings[0])) {
                result.append(strings[1]);
            }
        }
        boolean fizz = number % 3 == 0;
        boolean buzz = number % 5 == 0;
        if (fizz && buzz) return "Fizz Buzz";
        if (fizz) return "Fizz";
        if (buzz) return "Buzz";
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(FizzBuzz.FizzBuzzTranslate(35));
    }
}
