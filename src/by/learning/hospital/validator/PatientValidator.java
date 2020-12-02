package by.learning.hospital.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientValidator {
    private static final Logger logger = LogManager.getLogger(PatientValidator.class);

    private static final String NAME_REGEX = "^[[A-Z]|[a-z]]{1,20}$";
    private final static String PHONE_REGEX = "^[+[0-9]|[0-9]]{7,14}$";

    public static boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        boolean result = matcher.matches();
        logger.info("{} in name {}", result, name);
        return result;
    }

    public static boolean isPhoneValid(String phone) {
        if (phone == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        boolean result = matcher.matches();
        logger.info("{} in phone number {}", result, phone);
        return result;
    }
}
