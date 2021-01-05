package calculator.gears;

public class DivisionStep {
    
    private Integer reminderNumber;
    private Integer multiplyResult;
    private Integer mod;
    private int stepCounter;
    
    
    public DivisionStep(Integer reminderNumber, Integer multiplyResult, Integer mod, int stepCounter) {
        this.reminderNumber = reminderNumber;
        this.multiplyResult = multiplyResult;
        this.mod = mod;
        this.stepCounter = stepCounter;
    }
   

    public Integer getReminderNumber() {
        return reminderNumber;
    }
    public Integer getMultiplyResult() {
        return multiplyResult;
    }
    public Integer getMod() {
        return mod;
    }
    public int getStepCounter() {
        return stepCounter;
    }
    public void setReminderNumber(Integer reminderNumber) {
        this.reminderNumber = reminderNumber;
    }
    public void setMultiplyResult(Integer multiplyResult) {
        this.multiplyResult = multiplyResult;
    }
    public void setMod(Integer mod) {
        this.mod = mod;
    }
    public void setStepCounter(int stepCounter) {
        this.stepCounter = stepCounter;
    }
}