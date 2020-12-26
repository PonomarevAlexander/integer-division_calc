import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {
    
    DivisionFormatter formatter;
    private static Calculate calc = new Calculate();
    private static final int DIVIDEND = 375;
    private static final int DIVISOR = 9;
    private static final List<DivisionDTO> STAGES = calc.longDivisions(DIVIDEND, DIVISOR);
    private static final List<DivisionDTO> EMPTY_STAGES_LIST = new ArrayList<>();
    private static final String EXPECTED = "_375│9\n"
            + " 36 │--\n"
            + " -- │41\n"
            + " _15\n"
            + "   9\n"
            + "   --\n"
            + "   6\n";
    private static final String EMPTY_STAGES_EXCEPTION_MESSAGE = "This stages list is empty!!!";
    
    
    @BeforeEach
    void initObject() {
        formatter = new DivisionFormatter();
    }

    @Test
    void testFormatToPrint() {
        String actual = formatter.formatToPrint(STAGES);
        assertEquals(EXPECTED, actual);
    }
    
    @Test
    void testEmptyStagesList() {
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> {formatter.formatToPrint(EMPTY_STAGES_LIST);});
        assertEquals(EMPTY_STAGES_EXCEPTION_MESSAGE, ex.getMessage());
    }
}
