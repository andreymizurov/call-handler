package by.avmiz.repository;

import by.avmiz.exception.CallSaveException;
import by.avmiz.valueobject.CallVO;

/**
 * Interface for saving call information.
 *
 * @author avmiz created 08.02.2016 at 17:41.
 */
public interface CallRepository {

    /**
     * @param call CallVO object for saving.
     */
    void save(CallVO call) throws CallSaveException;
}
