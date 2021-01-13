package calculator.gears;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DivisionFormatterTest {

    private Calculator calculator;
    private DivisionFormatter formatter;
    private DivisionDto testDto;
    private static final int DIVIDEND = 4027;
    private static final int DIVISOR = 24;
    private static final String EXPECTED_RESULT = "_4027|24\n"
            + " 24  |---\n"
            + " --  |167\n"
            + "_162\n"
            + " 144\n"
            + " ---\n"
            + " _187\n"
            + "  168\n"
            + "  ---\n"
            + "   19\n";
    
    
    @BeforeEach
    void init() {
        formatter = new DivisionFormatter();
        calculator = new Calculator();
        testDto = calculator.calculate(DIVIDEND, DIVISOR);
    }
    
    
    @Test
    void testCheckToCorrectDtoIncomingToFormatToPrint() {
        assertNotNull(testDto.getDivisionStepList());
        assertNotNull(testDto.getReminder());
        assertNotSame(0, testDto.getDividendLength());
        assertNotSame(0, testDto.getDividend());
        assertNotSame(0, testDto.getDivisor());
    }
    
    @Test
    void testToReturnCorrectResultFromFormatToPrint() {
        String actual = formatter.formatToPrint(testDto);
        assertEquals(EXPECTED_RESULT, actual);
    }
}
