package by.avmiz;

import by.avmiz.util.CallSaveHelper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author avmiz created 10.02.2016 at 10:55.
 */
public class CallSaveHelperTest extends Assert {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final String filePath = System.getProperty("java.io.tmpdir") + File.separator
            + "CALL_HANDLER" + File.separator + LocalDateTime.now().format(DATE_FORMATTER)
            + File.separator + "IVANOV_IVAN.txt";

    @Test
    public void testSave() throws Exception {
        CallSaveHelper.on(TestDataGenerator.getCall()).save();
        File file = new File(filePath);
        String row = Files.readFirstLine(file, Charsets.UTF_8);
        assertNotNull(row);

    }
}
