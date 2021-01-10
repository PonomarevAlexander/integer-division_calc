package calculator.facade;

import calculator.gears.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorFacadeTest {
    
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
    private CalculatorFacade facade;
    private Calculator calculator;
    private DivisionFormatter formatter;
    private DivisionDto dto;
    
    
    
    @InjectMocks
    private CalculatorFacade mockedFacade;
    
    @Mock
    private Calculator mockedCalculator;
    
    @Mock
    private DivisionFormatter mockedFormatter;
    
    
    @Test
    void testTimesInvokationsLongDivisionMethod() {
        mockedFacade.longDivision(DIVIDEND, DIVISOR);
        
        verify(mockedCalculator).calculate(DIVIDEND, DIVISOR);
        verify(mockedFormatter).formatToPrint(dto);
    }
    
    @Test
    void testOrderVerifyLongDivisionMethod() {
        mockedFacade.longDivision(DIVIDEND, DIVISOR);
        InOrder inOrder = inOrder(mockedCalculator, mockedFormatter);
        
        inOrder.verify(mockedCalculator).calculate(DIVIDEND, DIVISOR);
        inOrder.verify(mockedFormatter).formatToPrint(dto);
    }
    
    @Test
    void testToCheckingReturnedResultOfLongDivisionMethod() {
        calculator = new Calculator();
        formatter = new DivisionFormatter();
        facade = new CalculatorFacade(formatter, calculator);
        
        String actual = facade.longDivision(DIVIDEND, DIVISOR);
        assertEquals(EXPECTED_RESULT, actual);
    }
}
