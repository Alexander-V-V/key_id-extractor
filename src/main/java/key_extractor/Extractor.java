package key_extractor;

import static key_extractor.Constants.LOADING_CERT_EX;
import static key_extractor.FileUtils.loadFile;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;

class Extractor {

    private static final Logger logger = Logger.getLogger(String.valueOf(Extractor.class));
    private static final String KEY_TEMPLATE = "SN=%s,CA=%s";

    /**
     * Generates keyId for signature signing from QSEAL certificate.
     *
     * @param certPath absolute path to certificate
     * @return keyId
     */
    static String extractKeyId(String certPath) {

        logger.info("Begin extracting key with path - " + certPath);

        CertificateFactory certificateFactory;
        X509Certificate certificate;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            certificate =
                    (X509Certificate) certificateFactory.generateCertificate(loadFile(certPath));
        } catch (CertificateException e) {
            throw new RuntimeException(LOADING_CERT_EX);
        }

        logger.info("Finish extracting key");
        return String.format(
                KEY_TEMPLATE,
                certificate.getSerialNumber(),
                certificate.getIssuerDN());
    }

}
