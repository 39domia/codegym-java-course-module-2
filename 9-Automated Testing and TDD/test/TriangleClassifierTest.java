import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void checkTriangle1() {
        String expected = "Deu";
        String result = TriangleClassifier.checkTriangle(2, 2, 2);
        assertEquals(expected, result);
    }
    @Test
    void checkTriangle2() {
        String expected = "Can";
        String result = TriangleClassifier.checkTriangle(2, 2, 3);
        assertEquals(expected, result);
    }
    @Test
    void checkTriangle3() {
        String expected = "Thuong";
        String result = TriangleClassifier.checkTriangle(3, 4, 5);
        assertEquals(expected, result);
    }
    @Test
    void checkTriangle4() {
        String expected = "Khong phai tam giac";
        String result = TriangleClassifier.checkTriangle(8, 2, 3);
        assertEquals(expected, result);
    }
    @Test
    void checkTriangle5() {
        String expected = "Khong phai tam giac";
        String result = TriangleClassifier.checkTriangle(-1, 2, 1);
        assertEquals(expected, result);
    }
    @Test
    void checkTriangle6() {
        String expected = "Khong phai tam giac";
        String result = TriangleClassifier.checkTriangle(0, 1, 1);
        assertEquals(expected, result);
    }

}