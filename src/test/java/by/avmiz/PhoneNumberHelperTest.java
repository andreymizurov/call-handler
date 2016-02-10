package by.avmiz;

import by.avmiz.util.PhoneNumberHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author avmiz created 10.02.2016 at 10:44.
 */
public class PhoneNumberHelperTest extends Assert {

    private static final String TELEPHONE_NUMBER = "+(420)-111222333";

    @Test
    public void testToUniformFormat() {
        String uniformNumber = PhoneNumberHelper.on(TELEPHONE_NUMBER).toUniformFormat();
        assertEquals("00420 111 222 333", uniformNumber);
    }
}
