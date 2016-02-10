package by.avmiz;

import by.avmiz.service.CallService;
import by.avmiz.valueobject.CommonResponseVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;

/**
 * @author avmiz created 10.02.2016 at 9:56.
 */

public class CallServiceTest extends ServiceTest {

    @Autowired
    public CallService callService;

    @Test
    public void testAddCall() {
        Response response = callService.addCall(TestDataGenerator.getCall());
        CommonResponseVO commonResponse = (CommonResponseVO) response.getEntity();
        Assert.assertEquals(CommonResponseVO.Status.OK, commonResponse.getStatus());
    }
}
