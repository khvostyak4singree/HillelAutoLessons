package MyCode;

import java.util.regex.Pattern;

/**
 * Created by hillel on 30.06.17.
 */
public class Code {
    public static boolean isNumberBetween(String input) {
        return Pattern.matches("^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$", input);
    }
    public static boolean isGmail(String input)
    {
        return Pattern.matches("^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$", input);
    }
}
