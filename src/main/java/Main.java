import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {
       Calculate calc = new Calculate();
       Formatter form = new Formatter();
//       Template t = new Template();
       List<DTO> stages = new ArrayList<>();
       String result;
       
       result = form.formatToPrint(calc.longDivisions(123, 3));
       System.out.println(result);
       
    }
}
