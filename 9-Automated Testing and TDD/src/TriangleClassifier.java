public class TriangleClassifier {
    public static String checkTriangle(int a, int b, int c) {
        if (a < (b + c) && b < (a + c) && c < (a + c)) {
            if(a == b && a == c ){
                return "Deu";
            }
            else if (a == b || b == c || a == c){
                return "Can";
            }
            else return "Thuong";
        }
        return "Khong phai tam giac";
    }

}
