package by.avmiz.valueobject;

import by.avmiz.util.PhoneNumberHelper;
import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Base value object for transfer through service information about call.
 * Use Bean Validation to check the filling of properties.
 *
 * @author avmiz created 08.02.2016 at 14:16.
 */
@XmlRootElement(name = "call")
public class CallVO implements Serializable {

    private static final long serialVersionUID = 42L;

    @Size(min = 1, max = 30)
    private String firstName;
    @NotNull()
    @Size(min = 1, max = 30)
    private String lastName;
    @Pattern(regexp = PhoneNumberHelper.VALID_FORMAT_REGEXP, message = "Invalid phone number format.")
    @NotNull()
    private String telephoneNumber;

    public CallVO() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("telephoneNumber", telephoneNumber).toString();
    }
}
