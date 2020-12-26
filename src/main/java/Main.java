import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorFacade facade = new CalculatorFacade(new DivisionFormatter(), new Calculate());
        
        while (true) {
            try {
                System.out.println("Enter first number or -1 for exit...");
                int firstNum = scanner.nextInt();
                if (firstNum == -1) {
                    scanner.close();
                    break;
                } else {
                    System.out.println("Enter second number...");
                    int secondNum = scanner.nextInt();
                
                    System.out.print("Enter action...");
                    String action = scanner.next();
                
                    if (action.equals("/")) {
                        String result = facade.longDivision(firstNum, secondNum);
                        System.out.println("\n" + result);
                    } else {
                        System.out.println("\n" + "We apologies it's action under development!");
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Somethink went wrong! please reboot the program");
                scanner.close();
                break;
                
            } catch (ArithmeticException ex) {
                System.out.println("\n" + "Hovewer, you are tryed divide by zero!!!");
            }
        }
    }
}
