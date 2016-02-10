package by.avmiz.exception;

import by.avmiz.valueobject.CommonResponseVO;
import org.apache.cxf.validation.ResponseConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Custom implementation ExceptionMapper for ValidationException
 * handling and prepare pretty response view for client.
 *
 * @author avmiz created 08.02.2016 at 21:38.
 */
@Provider
@Component("validationExceptionMapper")
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ValidationException> {
    private static final Logger LOG = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);

    @Override
    public Response toResponse(ValidationException exception) {
        Response.Status errorStatus = Response.Status.INTERNAL_SERVER_ERROR;
        CommonResponseVO commonResponse = CommonResponseVO.err();
        if (exception instanceof ConstraintViolationException) {
            final ConstraintViolationException violationException = (ConstraintViolationException) exception;
            for (ConstraintViolation<?> constraintViolation : violationException.getConstraintViolations()) {
                String errMessage = "Property [" + constraintViolation.getPropertyPath() + "] --> "
                        + constraintViolation.getMessage();
                commonResponse.addMessage(errMessage);
                LOG.warn("{}: {}", constraintViolation.getRootBeanClass().getSimpleName(), errMessage);
            }
            if (!(violationException instanceof ResponseConstraintViolationException)) {
                errorStatus = Response.Status.BAD_REQUEST;
            }
        }
        return Response.status(errorStatus).entity(commonResponse).build();

    }


}
