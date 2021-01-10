package calculator.gears;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;
    private DivisionDto dto;
    private static final int DIVIDEND = 4027;
    private static final int DIVISOR = 24;
    private static final int ZERO_DEVISOR = 0;

    
    @BeforeEach
    void init() {
        calculator = new Calculator();
        dto = calculator.calculate(DIVIDEND, DIVISOR);
    }
    
    @Test
    void testCheckingCorrectDtoWhichWasCreated() {
        assertNotNull(dto.getDivisionStepList());
        assertNotNull(dto.getReminder());
        assertNotSame(0, dto.getDividendLength());
        assertNotSame(0, dto.getDividend());
        assertNotSame(0, dto.getDivisor());
    }
    
    @Test
    void testShouldThrowExceptionWhileDividingByZero() {
        assertThrows(ArithmeticException.class, () -> {calculator.calculate(DIVIDEND, ZERO_DEVISOR);});
        
    }

}
