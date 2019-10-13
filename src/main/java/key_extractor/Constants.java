package key_extractor;

class Constants {
    // Constants
    static final String PROPERTIES_PATH = "src/main/resources/path_config.properties";
    static final String CERTIFICATE_PATH_KEY = "certificate.path";
    static final String KEY_OUT_PATH_KEY = "key.path";
    static final String DEFAULT_PATH = "";
    static final String OUT_FILE_NAME = "keyId.txt";
    // Error messages
    static final String LOADING_CERT_EX = "Error while loading certificate";
    static final String LOADING_FILE_EX = "Error while loading file";
    static final String READING_CERT_EX = "Cannot read certificate path";
    static final String WRITING_EX = "Error while writing to file";
}
