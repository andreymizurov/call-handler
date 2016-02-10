package by.avmiz;

import by.avmiz.util.PhoneNumberHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author avmiz created 08.02.2016 at 18:15.
 */
@RunWith(value = Parameterized.class)
public class TelephoneNumberValidationTest extends Assert {

    private static final Pattern PATTERN = Pattern.compile(PhoneNumberHelper.VALID_FORMAT_REGEXP);
    private String phoneNumber;
    private boolean expected;

    public TelephoneNumberValidationTest(String phoneNumber, boolean expected) {
        this.phoneNumber = phoneNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: testValidateNumber({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"+(420) 111 222 333", true},
                        {"+(420)-111222333", true},
                        {"+420111222333", true},
                        {"00420111222333", true},
                        {"(111) 222 (333)", true},
                        {"123456789", true},
                        {"-420111222333", false},
                        {"+00111222333", false},
                        {"(123 (123) 123", false},
                        {"12345678", false},
                        {"123.123/123", false},
                        {"00(420)000000000", false}
                }
        );
    }

    @Test
    public void testValidateNumber() throws Exception {
        Matcher matcher = PATTERN.matcher(phoneNumber);
        assertEquals(expected, matcher.matches());
    }

}
