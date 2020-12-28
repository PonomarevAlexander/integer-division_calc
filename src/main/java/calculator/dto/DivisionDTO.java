package calculator.dto;

public class DivisionDTO extends DTO {
    
    private StringBuilder reminder= new StringBuilder();
    private Integer reminderNumber;
    private Integer multiplyResult;
    private Integer divisorDigit;
    private Integer mod;
    private int dividend;
    private int divisor;
    private int index;
    private int digitCounter;
    
    
    public DivisionDTO(StringBuilder reminder, Integer reminderNumber,
            Integer multiplyResult, Integer divisorDigit, Integer mod, int dividend, int divisor, int index, int digitCounter) {
        this.reminder = reminder;
        this.reminderNumber = reminderNumber;
        this.multiplyResult = multiplyResult;
        this.divisorDigit = divisorDigit;
        this.mod = mod;
        this.dividend = dividend;
        this.divisor = divisor;
        this.index = index;
        this.digitCounter = digitCounter;
    }
   
    
    public StringBuilder getReminder() {
        return reminder;
    }
    public void setReminder(int index, int lastIndex, String mod) {
        this.reminder.replace(index, lastIndex, mod);
    }
    public Integer getReminderNumber() {
        return reminderNumber;
    }
    public void setReminderNumber(Integer reminderNumber) {
        this.reminderNumber = reminderNumber;
    }
    public Integer getMultiplyResult() {
        return multiplyResult;
    }
    public Integer getDivisorDigit() {
        return divisorDigit;
    }
    public Integer getMod() {
        return mod;
    }
    public int getDividend() {
        return dividend;
    }
    public int getDivisor() {
        return divisor;
    }
    public int getIndex() {
        return index;
    }
    public int getDigitCounter() {
        return digitCounter;
    }  
}
