import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorFacadeTest {
    
    DivisionFormatter formatter;
    Calculate calc;
    CalculatorFacade facade;
    private static final int DIVIDEND = 375;
    private static final int DIVISOR = 9;
    private static final String EXPECTED_RESULT = "_375│9\n"
            + " 36 │--\n"
            + " -- │41\n"
            + " _15\n"
            + "   9\n"
            + "   --\n"
            + "   6\n";
    
    
    @BeforeEach
    void testInitInstance() {
        formatter = new DivisionFormatter();
        calc = new Calculate();
        facade = new CalculatorFacade(formatter, calc);
    }
    
    @Test
    void testLongDivisionMethod() {
        String actual = facade.longDivision(DIVIDEND, DIVISOR);
        assertEquals(EXPECTED_RESULT, actual);
    }
}
