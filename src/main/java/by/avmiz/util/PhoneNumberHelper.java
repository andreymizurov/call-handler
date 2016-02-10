package by.avmiz.util;

/**
 * Utility class helper for validation and transformation telephone number to Uniform format.
 *
 * @author avmiz created 09.02.2016 at 13:14.
 */
public class PhoneNumberHelper {

    private static final String COUNTRY_CODE = "420";
    private static final String INTERNATIONAL_PREFIX = "00";
    private static final int INTERNATIONAL_PART_SIZE = 5;
    // Regular expression for validate international part in phone number like +(420) ,00420, +(420)-.
    private static final String INTERNATIONAL_PART_REGEXP = "(?:((\\+((\\(\\d{3}\\))|\\d{3}))" +
            "|(" + INTERNATIONAL_PREFIX + "\\d{3}))[\\s-]?)?";
    private static final int LOCAL_PART_SIZE = 9;
    // Regular expression for validate local part in phone number like 111 222 333, (123) 123 (123), 12345678.
    private static final String LOCAL_PART_REGEXP = "(((\\(\\d{3}\\))|\\d{3})[\\s-]?){3}";
    private static final String NOT_DIGITS_REGEXP = "[^\\d]";
    // Regular expression for validate telephone number format.
    public static final String VALID_FORMAT_REGEXP = "^" + INTERNATIONAL_PART_REGEXP + LOCAL_PART_REGEXP + "$";

    private final String phoneNumber;

    private PhoneNumberHelper(String phoneNUmber) {
        this.phoneNumber = phoneNUmber;
    }

    private static String clearPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll(NOT_DIGITS_REGEXP, "");
    }

    public static PhoneNumberHelper on(String phoneNumber) {
        return new PhoneNumberHelper(clearPhoneNumber(phoneNumber));
    }

    /**
     * @return Telephone number in uniform format 00YYY XXX XXX XXX.
     */
    public String toUniformFormat() {
        String rawNumber = phoneNumber;
        //Add International part if not present.
        if (rawNumber.length() != INTERNATIONAL_PART_SIZE + LOCAL_PART_SIZE) {
            if (rawNumber.length() == LOCAL_PART_SIZE) {
                rawNumber = INTERNATIONAL_PREFIX + COUNTRY_CODE + rawNumber;
            } else {
                rawNumber = INTERNATIONAL_PREFIX + rawNumber;
            }
        }
        // Format number and return, it's not pretty solution )))
        return String.format("%s %s %s %s",
                rawNumber.substring(0, 5),
                rawNumber.substring(5, 8),
                rawNumber.substring(8, 11),
                rawNumber.substring(11, 14));
    }
}
