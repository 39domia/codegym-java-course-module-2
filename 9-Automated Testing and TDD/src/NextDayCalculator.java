import java.util.Arrays;
import java.util.Scanner;

public class NextDayCalculator {
    public static int[] enterDayMonthYear() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day month year");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();
        return new int[]{day, month, year};
    }

    public static int checkLeapYear(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0)
                            return 29;
                    } else
                        return 29;
                }
                return 28;
            default:
                return -1;
        }
    }

    public static int[] update(int[] day) {
        if(day[0] == 31 && day[1] == 12){
            day[0] = 1;
            day[1] = 1;
            day[2]++;
            return day;
        }
        else if (day[0] == checkLeapYear(day[1], day[2])) {
            day[0] = 1;
            day[1]++;
        } else
            day[0]++;
        return day;
    }

    public static void main(String[] args) {
        int[] day = enterDayMonthYear();
        System.out.println(Arrays.toString(day));
        System.out.println("After update");
        System.out.println(Arrays.toString(update(day)));

//        int[] out = new int[3];

    }

}
