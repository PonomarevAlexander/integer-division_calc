package calculator.gears;
public class Calculator {
    
    public DivisionDto calculate(int dividend, int divisor) {
        DivisionDto divDto = new DivisionDto(Math.abs(dividend), Math.abs(divisor));
        String[] digits = String.valueOf(dividend).split("");
        divDto.setDivisorDigit((int) Math.log10(divisor) + 1);
        Integer reminderNumber;
        Integer multiplyResult;
        Integer mod;
        
       
        for (int i = 0; i < digits.length; i++) {
            divDto.addDigitToReminder(digits[i]);
            reminderNumber = Integer.parseInt(divDto.getReminder());
            
            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                
                divDto.addToDivisionStep(new DivisionStep(reminderNumber, multiplyResult, mod, i));
                
                divDto.refreshReminderOnStep(mod);
            }
        }
        return divDto;
    }
}

