
import java.util.List;

public class DivisionFormatter implements Formatter {
    
    @Override
    public String formatToPrint(List<DivisionDTO> divisionStages) {
        if (divisionStages.isEmpty()) {
            throw new IllegalArgumentException("This stages list is empty!!!");
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        int dividend = divisionStages.get(0).getDividend();
        int divisor = divisionStages.get(0).getDivisor();
        
        
        // There is extracting data from DTO.
        for (DivisionDTO stage : divisionStages) {
            if (stage.getReminderNumber() >= stage.getDivisor()) {
                String lastReminder = String.format("%" + (stage.getIndex() + 2) + "s", "_" + stage.getReminderNumber().toString());
                result.append(lastReminder).append("\n");
            
                String multiply = String.format("%" + (stage.getIndex() + 2) + "d", stage.getMultiplyResult());
                result.append(multiply).append("\n");
            
                Integer tab = lastReminder.length() - calculateDigit(stage.getMultiplyResult());
                result.append(makeDivider(stage.getReminderNumber(), tab)).append("\n");
            
                quotient.append(stage.getReminderNumber() / stage.getDivisor());
            
                stage.setReminder(0, stage.getReminder().length(), stage.getMod().toString()); // must refresh to 0 every iterations
                stage.setReminderNumber(Integer.parseInt(stage.getReminder().toString()));
            } else {
                if (stage.getIndex() >= stage.getDivisorDigit()) {
                    quotient.append(0);
                }
            } 
            
            if (stage.getIndex() == stage.getDigitCounter() - 1) {
                result.append(String.format("%" + (stage.getIndex() + 2) + "s", stage.getReminderNumber().toString())).append("\n");
            }
        }
        modifyResultToView(dividend, divisor, result, quotient);
        return result.toString();
    }
    
    private int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
    
    private String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }
    
    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
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