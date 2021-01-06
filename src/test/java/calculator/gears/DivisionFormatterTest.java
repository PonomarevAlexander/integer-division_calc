package calculator.gears;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DivisionFormatterTest {

    private static final int DIVIDEND = 4027;
    private static final int DIVISOR = 24;
    private Calculator calc = new Calculator();
    private DivisionDto testDto = calc.calculate(DIVIDEND, DIVISOR);
    
    @Test
    void testCheckToCorrectDtoIncomingToFormatToPrint() {
        assertNotNull(testDto.getDivisionStepList());
        assertNotNull(testDto.getReminder());
        assertNotSame(0, testDto.getDividendLength());
        assertNotSame(0, testDto.getDividend());
        assertNotSame(0, testDto.getDivisor());
    }
    

}
