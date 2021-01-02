package calculator.gears;
public class Calculator {
    
    public DivisionDto calculate(int dividend, int divisor) {
        DivisionDto divisionDto = new DivisionDto(Math.abs(dividend), Math.abs(divisor));
        String[] digits = String.valueOf(dividend).split("");
        Integer reminderNumber;
        Integer multiplyResult;
        Integer mod;
        divisionDto.setDivisorDigit((int) Math.log10(divisor) + 1);
        divisionDto.setDividendLength(digits.length);
        
       
        for (int i = 0; i < digits.length; i++) {
            divisionDto.addDigitToReminder(digits[i]);
            reminderNumber = Integer.parseInt(divisionDto.getReminder());
            
            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;
                
                divisionDto.addToDivisionStepList(new DivisionStep(reminderNumber, multiplyResult, mod, i));
                
                divisionDto.refreshReminderOnStep(mod);
            }
        }
        return divisionDto;
    }
}

