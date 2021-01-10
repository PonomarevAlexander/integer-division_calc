package calculator.facade;

import calculator.gears.*;

public class CalculatorFacade {
    
    private DivisionFormatter formatter;
    private Calculator calc;

    
    public CalculatorFacade(DivisionFormatter formatter, Calculator calculate) {
         this.formatter = formatter;
         this.calc = calculate;
    }
    
    
    public String longDivision(int dividend, int divisor) {
        DivisionDto divisionDto =  calc.calculate(dividend, divisor);
        return formatter.formatToPrint(divisionDto);  
    }
}
