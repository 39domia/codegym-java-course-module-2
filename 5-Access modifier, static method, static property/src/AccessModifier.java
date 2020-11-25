public class AccessModifier {
     int data = 40;

     void msg() {
        System.out.println("Hello java");
    }


}

class B {
    public static void main(String[] args) {

        AccessModifier obj = new AccessModifier();

        System.out.println(obj.data);//Compile Time Error

        obj.msg();//Compile Time Error

    }
}


