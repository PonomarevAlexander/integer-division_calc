import java.util.List;

public class DivisionFormatter implements Formatter {
    
    @Override
    public String formatToPrint(List<DTO> stages) {
        if (stages.isEmpty()) {
            throw new IllegalArgumentException("This stages list is empty!!!");
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        int dividend = ((DivisionDTO) stages.get(0)).getDividend();
        int divisor = ((DivisionDTO) stages.get(0)).getDivisor();
        
        
        // There is extracting data from DTO.
        for (DTO stage : stages) {
            //  Cast DTO to DivisionDTO one by one 
            DivisionDTO divisionStage = (DivisionDTO) stage;
            
            if (divisionStage.getReminderNumber() >= divisionStage.getDivisor()) {
                String lastReminder = String.format("%" + (divisionStage.getIndex() + 2)
                        + "s", "_" + divisionStage.getReminderNumber().toString());
                result.append(lastReminder).append("\n");
            
                String multiply = String.format("%" + (divisionStage.getIndex() + 2)
                        + "d", divisionStage.getMultiplyResult());
                result.append(multiply).append("\n");
            
                Integer tab = lastReminder.length() - calculateDigit(divisionStage.getMultiplyResult());
                result.append(makeDivider(divisionStage.getReminderNumber(), tab)).append("\n");
            
                quotient.append(divisionStage.getReminderNumber() / divisionStage.getDivisor());
            
                divisionStage.setReminder(0, divisionStage.getReminder().length(), 
                        divisionStage.getMod().toString());
                divisionStage.setReminderNumber(Integer.parseInt(divisionStage.getReminder().toString()));
            } else {
                if (divisionStage.getIndex() >= divisionStage.getDivisorDigit()) {
                    quotient.append(0);
                }
            } 
            
            if (divisionStage.getIndex() == divisionStage.getDigitCounter() - 1) {
                result.append(String.format("%" + (divisionStage.getIndex() + 2) + "s", 
                        divisionStage.getReminderNumber().toString())).append("\n");
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