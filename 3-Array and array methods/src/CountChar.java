import java.util.Scanner;

public class CountChar {
    public static void main(String[] args) {
        String str = "asdfaaaghjkl";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character");
        String ch = sc.nextLine();
        int count = 0;
        for(int i  = 0; i< str.length() ; i++){
            if(String.valueOf(str.charAt(i)).equals(ch)){
                count++;
            }
        }
        System.out.println(count);


    }
}
