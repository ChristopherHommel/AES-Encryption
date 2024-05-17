package main.java.com.waikato.domain;

/**
 * Encrypt our file using ECB
 */
public class ECBEncryption extends AbstractBaseEncryption {

    private static final String ALGORITHM_TYPE = "AES/ECB/PKCS5Padding";
    private static final String OUTPUT_FILE_NAME = "ECB";

    @Override
    protected String getOutputFileName() {
        return OUTPUT_FILE_NAME;
    }

    @Override
    protected String getAlgorithm() {
        return ALGORITHM_TYPE;
    }
}
