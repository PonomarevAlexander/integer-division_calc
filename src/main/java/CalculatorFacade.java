import java.util.List;

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
