package main.java.com.waikato.domain;

import java.security.SecureRandom;

/**
 * Encrypt our file using CFB
 */
public class CFBEncryption extends AbstractBaseEncryption{

    private static final String ALGORITHM_TYPE = "AES/CFB/PKCS5Padding";
    private static final String OUTPUT_FILE_NAME = "CFB";

    public CFBEncryption() {
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
    protected String getAlgorithm() {
        return ALGORITHM_TYPE;
    }

    @Override
    protected String getOutputFileName() {
        return OUTPUT_FILE_NAME;
    }
}
