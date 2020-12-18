import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {
       Division div = new Division();
       Scanner scanner = new Scanner(System.in);
       
       try {
           while (true) {
               System.out.println("Please, type a dividend or type 'Q' for exit programm");
               int dividend = scanner.nextInt();
               if (dividend == 'q') {
                   scanner.close();
                   break;
               }
               System.out.println("Type a divisor");
               int divisor = scanner.nextInt();
           
               String result = div.makeDivision(dividend, divisor);
               System.out.println(result);
           }
       } catch (InputMismatchException ex) {
           System.out.println("See you later");
       }
    }
}
