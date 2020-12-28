package calculator.facade;

import java.util.List;
import calculator.dto.DTO;
import calculator.gears.Calculate;
import calculator.gears.DivisionFormatter;

public class CalculatorFacade {
    
    private DivisionFormatter formatter;
    private Calculate calculate;

    public CalculatorFacade(DivisionFormatter formatter, Calculate calculate) {
         this.formatter = formatter;
         this.calculate = calculate;
    }
    
    public String longDivision(int dividend, int divisor) {
        List<DTO> stages = calculate.longDivisions(dividend, divisor);
        return formatter.formatToPrint(stages);
        
    }
}
