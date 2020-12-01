public class FizzBuzz2 {
    public static String FizzBuzzTranslate2(int number) {
        if (number <= 0) return "invalid";
        String str = "" + number;
        String[] arr = str.split("");
        if(arr[0].equals("3") && arr[1].equals("5") || arr[1].equals("3") && arr[0].equals("5")){
            return "FizzBuzz";
        }
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
        String result = "";
        for (String[] strings : arr2) {
            if (arr[0].equals(strings[0])) {
                result += strings[1];
            }
        }
        for (String[] strings : arr2) {
            if (arr[1].equals(strings[0])) {
                result += strings[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FizzBuzz2.FizzBuzzTranslate2(27));
    }
}
