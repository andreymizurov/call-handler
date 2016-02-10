package by.avmiz.repository;

import by.avmiz.exception.CallSaveException;
import by.avmiz.util.CallSaveHelper;
import by.avmiz.valueobject.CallVO;
import org.springframework.stereotype.Repository;

/**
 * @author avmiz created 08.02.2016 at 17:55.
 */
@Repository
public class CallRepositoryImpl implements CallRepository {


    @Override
    public void save(CallVO call) throws CallSaveException {
        CallSaveHelper.on(call).save();
    }
}
