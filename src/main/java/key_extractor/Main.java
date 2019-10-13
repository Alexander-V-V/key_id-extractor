package key_extractor;

import static key_extractor.Constants.CERTIFICATE_PATH_KEY;
import static key_extractor.Constants.DEFAULT_PATH;
import static key_extractor.Constants.KEY_OUT_PATH_KEY;
import static key_extractor.FileUtils.loadProperties;
import static key_extractor.FileUtils.writeKeyToFile;

import java.util.Properties;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {

        Properties properties = loadProperties();
        String certificatePath = properties.getProperty(CERTIFICATE_PATH_KEY);
        String keyOutPath =
                properties.getProperty(KEY_OUT_PATH_KEY) == null
                        ? DEFAULT_PATH
                        : properties.getProperty(KEY_OUT_PATH_KEY);

        logger.info("Properties loaded successfully");
        writeKeyToFile(Extractor.extractKeyId(certificatePath), keyOutPath);
        logger.info("KeyId extracted successfully");
    }
}
