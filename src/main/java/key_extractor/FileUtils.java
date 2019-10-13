package key_extractor;

import static key_extractor.Constants.LOADING_FILE_EX;
import static key_extractor.Constants.OUT_FILE_NAME;
import static key_extractor.Constants.PROPERTIES_PATH;
import static key_extractor.Constants.READING_CERT_EX;
import static key_extractor.Constants.WRITING_EX;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;

class FileUtils {

    private static final Logger logger = Logger.getLogger(String.valueOf(FileUtils.class));

    /**
     * Loads file as stream.
     *
     * @param path path to loaded file
     * @return InputStream
     */
    static InputStream loadFile(String path) {
        try {
            return new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(LOADING_FILE_EX);
        }
    }

    /**
     * Writes extracted key to file.
     *
     * @param keyId extracted keyId
     * @param keyOutPath path to file where will write a keyId
     */
    static void writeKeyToFile(String keyId, String keyOutPath) {
        logger.info("Writing keyId to file");
        try {
            Files.write(Paths.get(keyOutPath.concat(OUT_FILE_NAME)), keyId.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(WRITING_EX);
        }
    }

    /**
     * Loads properties from file.
     *
     * @return Properties
     */
    static Properties loadProperties() {
        logger.info("Loading properties");
        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(READING_CERT_EX);
        }
    }
}
