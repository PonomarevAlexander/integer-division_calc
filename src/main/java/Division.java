public class Division {

    private StringBuilder reminder = new StringBuilder();
    Formatter form = new Formatter();

    public String makeDivision(int dividend, int divisor) {
        
        if (divisor == 0) {
            throw new IllegalArgumentException("Wrong divisor, it's cannot be zero");
        }

        if (dividend < divisor) {
            return "The result of this expression is zero!";
        }

        String[] digits = String.valueOf(dividend).split("");
        Integer reminderNumber;
        Integer multiplyResult;
        Integer divisorDigit = (int) (Math.log10(divisor) + 1);
        Integer mod;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;

                form.makeLastReminder(reminderNumber, i);
                form.makeMultiply(multiplyResult, i);
                form.makeTab(multiplyResult, reminderNumber);
                form.appendToQuotient(reminderNumber / divisor);
                
                reminder.replace(0, reminder.length(), mod.toString());
                reminderNumber = Integer.parseInt(reminder.toString());
            } else {
                if (i >= divisorDigit) {
                    form.appendToQuotient(0);
                }
            }

            if (i == digits.length - 1) {
                form.makeLastLine(reminderNumber, i);
            }            
        }
        form.modifyResultToView(dividend, divisor);
        return form.getResult();
    }

}