import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {
    @Test
    void checkLeapYear() {
        int month = 2;
        int year = 2020;
        int expected = 29;
        int result = NextDayCalculator.checkLeapYear(month, year);
        assertEquals(expected, result);
    }
}