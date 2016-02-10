package by.avmiz.service;

import by.avmiz.exception.CallSaveException;
import by.avmiz.repository.CallRepository;
import by.avmiz.valueobject.CallVO;
import by.avmiz.valueobject.CommonResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;


/**
 * @author avmiz created 08.02.2016 at 16:03.
 */
@Service("callServiceImpl")
public class CallServiceImpl implements CallService {

    @Autowired
    CallRepository callRepository;

    @Override
    public Response addCall(CallVO call) {
        CommonResponseVO responseVO = CommonResponseVO.ok();
        try {
            callRepository.save(call);
            responseVO.addMessage("Call added successfully");
        } catch (CallSaveException e) {
            responseVO.setStatus(CommonResponseVO.Status.ERR);
            responseVO.addMessage("Can't save information about Call, please try again.");
        }
        return Response.ok(responseVO).build();
    }
}
