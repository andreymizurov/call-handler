package by.avmiz;

import by.avmiz.valueobject.CallVO;

/**
 * @author avmiz created 10.02.2016 at 10:46.
 */
public class TestDataGenerator {

    public static CallVO getCall() {
        CallVO call = new CallVO();
        call.setFirstName("Ivan");
        call.setLastName("Ivanov");
        call.setTelephoneNumber("+(420) 111222333");
        return call;
    }
}
