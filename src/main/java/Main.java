import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DivisionFormatter form = new DivisionFormatter();
        Calculate calc = new Calculate();
        
        
        try {
            while (true) {
                System.out.println("Enter dividend...");
                int dividend = scanner.nextInt();
                if (dividend == 'q') {
                    scanner.close();
                    break;
                } else {
                    System.out.println("Enter divisor...");
                    int divisor = scanner.nextInt();
                
                    if (divisor == 0) {
                        throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
                    }
                
                    if (dividend < divisor) {
                        System.out.println("The result of this expression is zero!");
                    } else {
                        String result; 
                        result = form.formatToPrint(calc.longDivisions(dividend, divisor));
                        System.out.println(result);
                    }
                }
            } 
        } catch (InputMismatchException ex){
            System.out.println("Somethink went wrong, please try again");
        }
    }
}
