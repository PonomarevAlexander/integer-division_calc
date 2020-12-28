package calculator.facade;
import java.util.InputMismatchException;
import java.util.Scanner;

import calculator.gears.Calculate;
import calculator.gears.DivisionFormatter;

public class Main {

    public static void main(String[] args) {
        final String SEPARATOR = "------------------------------------";
        final String WARNING_SEPARATOR = "=================================================";
        Scanner scanner = new Scanner(System.in);
        CalculatorFacade facade = new CalculatorFacade(new DivisionFormatter(), new Calculate());
        
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
                
                    if (action.equals("/")) {
                        System.out.println("\n" + SEPARATOR);
                        String result = facade.longDivision(firstNum, secondNum);
                        System.out.println("\n" + result);
                    } else {
                        System.out.println("\n" + "We apologies it's action under development!");
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println(WARNING_SEPARATOR);
                System.out.println("Somethink went wrong! please reboot the program");
                System.out.println(WARNING_SEPARATOR);
                scanner.close();
                
            } catch (ArithmeticException ex) {
                System.out.println("\n" + WARNING_SEPARATOR);
                System.out.println("Possibly, you are tryed divide by zero!!!");
                System.out.println(WARNING_SEPARATOR);
            }
        }
    }
}
