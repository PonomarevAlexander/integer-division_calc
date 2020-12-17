import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionTest {
    
    Division div;
    private static final int DIVISOR = 5;
    private static final int DIVIDEND = 123;
    private static final int ANOTHER_DEVIDEND = 1;
    private static final String ZERO_DEVISOR_EXCEPTION_MESSEGE = "Wrong divisor, it's cannot be zero";
    private static final String DIVIDEND_LESS_DIVISOR_RESULT = "The result of this expression is zero!";
    private static final String EXPECTED_RESULT = 
              "_123│5\n"
            + " 10 │--\n"
            + " -- │24\n"
            + " _23\n"
            + "  20\n"
            + "  --\n"
            + "   3\n"
            + "";
    
    
    @BeforeEach
    void initObjects() {
        div = new Division();
    }

    @Test
    void DivisionByZeroTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> {div.makeDivision(DIVIDEND, 0);});
        assertEquals(ZERO_DEVISOR_EXCEPTION_MESSEGE, exception.getMessage());
    }
    
    @Test
    void ifDividendLessDivisorTest() {
        String expect = DIVIDEND_LESS_DIVISOR_RESULT;
        String actual = div.makeDivision(ANOTHER_DEVIDEND, DIVISOR);
        assertEquals(expect, actual);
    }
    
    @Test
    void makeDivisionMethodTest() {
        String actual = div.makeDivision(DIVIDEND, DIVISOR);
        assertEquals(EXPECTED_RESULT, actual);
    }

}
