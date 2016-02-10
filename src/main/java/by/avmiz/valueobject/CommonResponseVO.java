package by.avmiz.valueobject;

import com.google.common.base.MoreObjects;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The base class of all the responses to service requests.
 *
 * @author avmiz created 08.02.2016 at 14:29.
 */
@XmlRootElement(name = "commonResponse")
public class CommonResponseVO implements Serializable {

    private static final long serialVersionUID = 42L;

    public enum Status {
        ERR,
        OK
    }

    private Status status;
    private List<String> messages = new ArrayList<>();

    public CommonResponseVO() {
    }

    private CommonResponseVO(Status status) {
        this.status = status;
    }

    public static CommonResponseVO err() {
        return new CommonResponseVO(Status.ERR);
    }

    public static CommonResponseVO ok() {
        return new CommonResponseVO(Status.OK);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("status", status)
                .add("messages", messages)
                .toString();
    }

}
