package calculator.facade;

import java.util.InputMismatchException;
import java.util.Scanner;
import calculator.gears.Calculator;
import calculator.gears.DivisionFormatter;

public class Main {
    
    private static final String NEW_LINE = "\n";
    private static final String SLASH = "/";
    private static final String SEPARATOR = "------------------------------------";
    private static final String WARNING_SEPARATOR = "=================================================";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorFacade facade = new CalculatorFacade(new DivisionFormatter(), new Calculator());
        
        while (true) {
            try {
                System.out.println(SEPARATOR);
                System.out.println("Enter first number or -1 for exit...");
                int firstNum = scanner.nextInt();
                if (firstNum == -1) {
                    scanner.close();
                    break;
                } else {
                    System.out.println(SEPARATOR);
                    System.out.println("Enter second number...");
                    int secondNum = scanner.nextInt();
                
                    System.out.println(SEPARATOR);
                    System.out.print("Enter action...");
                    String action = scanner.next();
                
                    if (action.equals(SLASH)) {
                        System.out.println(NEW_LINE + SEPARATOR);
                        String result = facade.longDivision(firstNum, secondNum);
                        System.out.println(NEW_LINE + result);
                    } else {
                        System.out.println(NEW_LINE + "We apologies it's action under development!");
                    }
                }
            } catch (InputMismatchException | IllegalStateException ex) {
                System.out.println(WARNING_SEPARATOR);
                System.out.println("Somethink went wrong! please reboot the program");
                System.out.println(WARNING_SEPARATOR);
                scanner.close();
                
            } catch (ArithmeticException ex) {
                System.out.println(NEW_LINE + WARNING_SEPARATOR);
                System.out.println("Possibly, you are tryed divide by zero!!!");
                System.out.println(WARNING_SEPARATOR); 
            }
        }
    }
}
