package calculator.gears;

public class DivisionFormatter implements Formatter {
    
    private static final String SUBTRACT = "_";
    private static final String SIDE_SEPARATOR = "|";
    private static final char DIVIDER_SEPARATOR = '-';
    private static final char SPACE = ' ';
    private static final String NEW_LINE = "\n";
    private static final char NEW_LINE_CHAR = '\n';
    
    @Override
    public String formatToPrint(DivisionDto dto) {
        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        
        for (DivisionStep step : dto.getDivisionStepList()) {
            if (step.getReminderNumber() >= dto.getDivisor()) {
                String lastReminder = String.format("%" + (step.getStepCounter() + 2) + "s", SUBTRACT + step.getReminderNumber().toString());
                result.append(lastReminder).append(NEW_LINE);
            
                String multiply = String.format("%" + (step.getStepCounter() + 2) + "d", step.getMultiplyResult());
                result.append(multiply).append(NEW_LINE);
            
                Integer tab = lastReminder.length() - calculateDigit(step.getMultiplyResult());
                result.append(makeDivider(step.getReminderNumber(), tab)).append(NEW_LINE);
            
                quotient.append(step.getReminderNumber() / dto.getDivisor());
            
                dto.refreshReminderOnStep(step.getMod());
                step.setReminderNumber(Integer.parseInt(dto.getReminder()));
            } else {
                if (step.getStepCounter() >= dto.getDivisorDigit()) {
                    quotient.append(0);
                }
            }
            
            if (step.getStepCounter() == dto.getDividendLength() - 1) {
                result.append(String.format("%" + (step.getStepCounter() + 2) + "s", step.getReminderNumber().toString())).append(NEW_LINE); 
            }
        }
        modifyResultToView(dto.getDividend(), dto.getDivisor(), result, quotient);
        return result.toString();
    }
    
    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
    
    private String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, SPACE) + assemblyString(calculateDigit(reminderNumber), DIVIDER_SEPARATOR);
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
            if (result.charAt(i) == NEW_LINE_CHAR) {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        
        int tab = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], assemblyString(tab, SPACE) + SIDE_SEPARATOR + quotient.toString());
        result.insert(index[1], assemblyString(tab, SPACE) + SIDE_SEPARATOR + assemblyString(quotient.length(), DIVIDER_SEPARATOR));
        result.insert(index[0], SIDE_SEPARATOR + divisor);
        result.replace(1, index[0], dividend.toString());
    }
}