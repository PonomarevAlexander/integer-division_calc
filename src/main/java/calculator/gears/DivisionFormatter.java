package calculator.gears;

public class DivisionFormatter implements Formatter {
    
    @Override
    public String formatToPrint(DivisionDto dto) {
        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        
        for (DivisionStep step : dto.getDivisionStepList()) {
            if (step.getReminderNumber() >= dto.getDivisor()) {
                String lastReminder = String.format("%" + (step.getStepCounter() + 2)
                        + "s", "_" + step.getReminderNumber().toString());
                result.append(lastReminder).append("\n");
            
                String multiply = String.format("%" + (step.getStepCounter() + 2)
                        + "d", step.getMultiplyResult());
                result.append(multiply).append("\n");
            
                Integer tab = lastReminder.length() - calculateDigit(step.getMultiplyResult());
                result.append(makeDivider(step.getReminderNumber(), tab)).append("\n");
            
                quotient.append(step.getReminderNumber() / dto.getDivisor());
            
                dto.refreshReminderOnStep(step.getMod());
                step.setReminderNumber(Integer.parseInt(dto.getReminder()));
            } else {
                if (step.getStepCounter() >= dto.getDivisorDigit()) {
                    quotient.append(0);
                }
            } 
            
            if (step.getStepCounter() == dto.getDividendLength() - 1) {
                result.append(String.format("%" + (step.getStepCounter() + 2) + "s", 
                        step.getReminderNumber().toString())).append("\n"); 
            }
        }
        modifyResultToView(dto.getDividend(), dto.getDivisor(), result, quotient);
        return result.toString();
    }
    
    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
    
    private String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }
    
    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            result.append(symbol);
        }
        return result.toString();
    }
    
    private void modifyResultToView(Integer dividend, Integer divisor, StringBuilder result, StringBuilder quotient) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], assemblyString(tab, ' ') +"│" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') +"│" + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }
}