import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<>();
//        ArrayList<String> arr2 = new ArrayList<>();
//
//        arr.add("aa");
//        arr.add("bb");
//        arr.add("cc");
//
//        arr2.add("11");
//        arr2.add("22");
//        arr2.add("33");
////        arr.add(1, "dd");
//        arr.addAll(1, arr2);
//
//        arr.trimToSize();
//        System.out.println(arr);
//
//        Iterator itr = arr.iterator();
//        while (itr.hasNext()) {
//            Object element = itr.next();
//            System.out.println(element);
//        }

        List<String> collect = new LinkedList<>();
        collect.add("New York");
        collect.add("Atlanta");
        collect.add("Dallas");
        collect.add("Madison");
//        Iterator<String> iterator = collect.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next().toUpperCase() + "    ");
//        }
        System.out.println(collect.remove("Atlanta"));
        System.out.println(collect);

    }


}
