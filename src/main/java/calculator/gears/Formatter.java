package calculator.gears;

import java.util.List;
import calculator.dto.DTO;

public interface Formatter {

    String formatToPrint(List<DTO> stages);
}
