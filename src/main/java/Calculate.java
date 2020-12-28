
import java.util.ArrayList;
import java.util.List;

public class Calculate {
    
    public List<DTO> longDivisions(int dividend, int divisor) {
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        List<DTO> stages = new ArrayList<>();
        StringBuilder reminder = new StringBuilder();
        String[] digits = String.valueOf(dividend).split("");
        Integer divisorDigit = (int) Math.log10(divisor) + 1;
        Integer reminderNumber;
        Integer multiplyResult;
        Integer mod;
        
       
        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());
            
            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                
                stages.add(new DivisionDTO(reminder, reminderNumber, multiplyResult, 
                        divisorDigit, mod, dividend, divisor, i, digits.length));
                
                reminder.replace(0, reminder.length(), mod.toString());
            }
        }
        return stages;
    }
}

