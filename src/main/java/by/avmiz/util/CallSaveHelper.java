package by.avmiz.util;

import by.avmiz.exception.CallSaveException;
import by.avmiz.valueobject.CallVO;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class helper for saving Call data to file.
 *
 * @author avmiz created 09.02.2016 at 16:35.
 */
public class CallSaveHelper {

    private static final Logger LOG = LoggerFactory.getLogger(CallSaveHelper.class);

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final String ROOT_DIR = "CALL_HANDLER";
    private final LocalDateTime now = LocalDateTime.now();
    private static final String FILE_TXT_EXTENSION = ".txt";

    private final CallVO call;

    private CallSaveHelper(CallVO call) {
        this.call = call;
    }

    public static CallSaveHelper on(CallVO call) {

        return new CallSaveHelper(call);
    }

    /**
     * @return Prepared and return file name by format LASTNAME_FIRSTNAME.txt.
     */
    private String getFileName() {
        String result = call.getLastName().toUpperCase();
        if (call.getFirstName() != null) {
            result = result + "_" + call.getFirstName().toUpperCase();
        }
        return result + FILE_TXT_EXTENSION;
    }

    /**
     * @return Root File directory for saving data about Call.
     * It's will be temp directory OS for example Windows (C:\Temp\CALL_HANDLER/yyyyMMdd)
     * or temp directory  container that is running.
     */
    private File getFile() {
        File baseDir = new File(System.getProperty("java.io.tmpdir")
                + File.separator + ROOT_DIR + File.separator + now.format(DATE_FORMATTER));
        return new File(baseDir, getFileName());
    }

    /**
     * @return Prepared row data for saving to file.
     */
    private String getRowForSave() {
        String row = PhoneNumberHelper.on(call.getTelephoneNumber()).toUniformFormat();
        return (row + " | " + now.format(TIME_FORMATTER) + "\n");
    }

    public void save() throws CallSaveException {
        String saveRow = getRowForSave();
        File file = getFile();
        try {
            Files.createParentDirs(file);
            Files.append(saveRow, file, Charsets.UTF_8);
            LOG.debug("Save --> {} to file:{}, successfully", saveRow, file);
        } catch (IOException e) {
            LOG.error("Not save --> {} to file:{}, follows stack trace:", saveRow, file, e);
            throw new CallSaveException(e);
        }


    }


}
