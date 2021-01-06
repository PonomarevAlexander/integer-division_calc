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
    
    @InjectMocks
    private CalculatorFacade facade;
    
    @Mock
    Calculator calculator;
    @Mock
    DivisionFormatter formatter;
    
    
    @Test
    void testTimesVerifyLongDivisionMethod() {
        facade.longDivision(anyInt(), anyInt());
        
        verify(calculator).calculate(anyInt(), anyInt());
        verify(formatter).formatToPrint(any());
    }
    
    @Test
    void testOrderVerifyLongDivisionMethod() {
        facade.longDivision(anyInt(), anyInt());
        InOrder inOrder = inOrder(calculator, formatter);
        
        inOrder.verify(calculator).calculate(anyInt(), anyInt());
        inOrder.verify(formatter).formatToPrint(any());
    }
}
