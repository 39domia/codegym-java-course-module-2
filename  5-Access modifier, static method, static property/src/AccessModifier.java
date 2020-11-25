public class A {
    private int data = 40;

    private void msg() {
        System.out.println("Hello java");
    }


}

class B {
    public static void main(String[] args) {

        A obj = new A();

        System.out.println(obj.data);//Compile Time Error

        obj.msg();//Compile Time Error

    }
}


