package main.java.com.waikato.domain;

import java.security.SecureRandom;

/**
 * Encrypt our file using CBC
 */
public class CBCEncryption extends AbstractBaseEncryption {

    private static final String ALGORITHM_TYPE = "AES/CBC/PKCS5Padding";
    private static final String OUTPUT_FILE_NAME = "CBC";

    public CBCEncryption() {
        super();

        generateIV();
    }

    /**
     * Generate the IV for this data
     */
    private void generateIV() {
        data = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(data);
    }

    @Override
    protected String getOutputFileName() {
        return OUTPUT_FILE_NAME;
    }

    @Override
    protected String getAlgorithm() {
        return ALGORITHM_TYPE;
    }
}