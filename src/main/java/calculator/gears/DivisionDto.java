package calculator.gears;

import java.util.ArrayList;
import java.util.List;

public class DivisionDto {

        private StringBuilder reminder = new StringBuilder();
        private int dividend;
        private int divisor;
        private int dividendLength;  
        private List<DivisionStep> divisionStepList = new ArrayList<>();
        private Integer divisorDigit;
        
        
        public DivisionDto(int dividend, int divisor) {
            this.dividend = dividend;
            this.divisor = divisor;
        }
        
        
        public String getReminder() {
            return reminder.toString();
        }
        public int getDividend() {
            return dividend;
        }
        public int getDivisor() {
            return divisor;
        }
        public List<DivisionStep> getDivisionStepList() {
            return divisionStepList;
        }
        public void addDigitToReminder(String digit) {
            this.reminder.append(digit);
        }
        public void refreshReminderOnStep(Integer mod) {
            this.reminder.replace(0, reminder.length(), mod.toString());
        }
        public void setDividend(int dividend) {
            this.dividend = dividend;
        }
        public void setDivisor(int divisor) {
            this.divisor = divisor;
        }
        public void addToDivisionStepList(DivisionStep step) {
            this.divisionStepList.add(step);
        }
        public Integer getDivisorDigit() {
            return divisorDigit;
        }
        public void setDivisorDigit(Integer divisorDigit) {
            this.divisorDigit = divisorDigit;
        }
        public int getDividendLength() {
            return dividendLength;
        }
        public void setDividendLength(int dividerLength) {
            this.dividendLength = dividerLength;
        }
        
        
        
        
}
