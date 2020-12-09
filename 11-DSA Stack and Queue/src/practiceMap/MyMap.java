package practiceMap;

import java.util.Map;
import java.util.TreeMap;

public class MyMap {
    public static void main(String[] args) {
        String str = "a a b b c a a a a";
        str = str.toLowerCase();
        String[] arr = str.split(" ");

        int count = 0;
        Map<Integer, String> map = new TreeMap<>();
        boolean flag;
        for (String s : arr) {
            flag = false;
            for (int j = 1; j <= map.size(); j++) {
                if (s.equals(map.get(j))) {
                    flag = true;
                }
            }
            if (!flag) {
                map.put(++count, s);
            }
        }
        //count  = 3
        System.out.println(map);
        System.out.println(count);
    }
}
