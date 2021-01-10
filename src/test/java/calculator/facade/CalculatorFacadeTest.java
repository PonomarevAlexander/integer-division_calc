package calculator.facade;

import calculator.gears.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorFacadeTest {
    
    private static final int DIVIDEND = 47625;
    private static final int DIVISOR = 20;
    private DivisionDto dto;
    
    
    @InjectMocks
    private CalculatorFacade facade;
    
    @Mock
    Calculator calculator;
    
    @Mock
    DivisionFormatter formatter;
    
    
    @Test
    void testTimesVerifyLongDivisionMethod() {
        facade.longDivision(DIVIDEND, DIVISOR);
        
        verify(calculator).calculate(DIVIDEND, DIVISOR);
        verify(formatter).formatToPrint(dto);
    }
    
    @Test
    void testOrderVerifyLongDivisionMethod() {
        facade.longDivision(DIVIDEND, DIVISOR);
        InOrder inOrder = inOrder(calculator, formatter);
        
        inOrder.verify(calculator).calculate(DIVIDEND, DIVISOR);
        inOrder.verify(formatter).formatToPrint(dto);
    }
}
