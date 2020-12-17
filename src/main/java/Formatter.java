public class Formatter {
    
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder result = new StringBuilder();
    private int lastReminderLength; 
    
    
    public void makeLastReminder(Integer reminderNumber, int index) {
        String lastReminder = String.format("%" + (index + 2) + "s", "_" + reminderNumber.toString());
        this.lastReminderLength = lastReminder.length();
        result.append(lastReminder).append("\n");
    }
    
    public void makeMultiply(Integer multiplyResult, int index ) {
        String multiply = String.format("%" + (index + 2) + "d", multiplyResult);
        result.append(multiply).append("\n");
    }
    
    public void makeTab(int multiplyResult, Integer reminderNumber) {
        Integer tab = this.lastReminderLength - calculateDigit(multiplyResult);
        result.append(makeDivider(reminderNumber, tab)).append("\n");
    }
    
    public void makeLastLine(Integer reminderNumber, int index) {
        result.append(String.format("%" + (index + 2) + "s", reminderNumber.toString())).append("\n");
    }
    
    public void modifyResultToView(Integer dividend, Integer divisor) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {break;}
        }

        int tab = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], assemblyString(tab, ' ') +"│" + quotient.toString());
        result.insert(index[1], assemblyString(tab, ' ') +"│" + assemblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }
    
    public String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
    
    public String makeDivider(Integer reminderNumber, Integer tab) {
        return assemblyString(tab, ' ') + assemblyString(calculateDigit(reminderNumber), '-');
    }
    
    public int calculateDigit(int i) {
        return (int) Math.log10(i) + 1;
    }
    
    public void appendToQuotient(Integer i) {
        this.quotient.append(i);
    }
    
    public String getResult() {
        return this.result.toString();
    }
}
