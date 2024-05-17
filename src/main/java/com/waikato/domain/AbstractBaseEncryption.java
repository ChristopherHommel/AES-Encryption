package main.java.com.waikato.domain;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

/**
 * Abstract class for providing encryption functionality
 */
public abstract class AbstractBaseEncryption extends Reader {

    private static final String ENCRYPTION_BASE_TYPE = "AES";
    private static final int BMP_HEADER_SIZE = 54;
    protected SecretKey secretKey;
    protected byte[] data;

    public AbstractBaseEncryption() {
        super();

        readFiles();
        generateKey();
    }

    /**
     * Get the algorithm to be used for encryption
     *
     * @return Algorithm to be used for encryption
     */
    protected abstract String getAlgorithm();

    /**
     * Get the output file name
     *
     * @return Output file name
     */
    protected abstract String getOutputFileName();

    /**
     * Encrypts a BMP file, extracting the header bits and encrypting the body data
     */
    public void encrypt() {
        byte[] data = getFileData();

        if (data == null || data.length == 0) {
            return;
        }

        try {
            byte[] header = Arrays.copyOfRange(data, 0, BMP_HEADER_SIZE);
            byte[] pixelData = Arrays.copyOfRange(data, BMP_HEADER_SIZE, data.length);

            Cipher cipher = Cipher.getInstance(getAlgorithm());
            if (this.data != null) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, new javax.crypto.spec.IvParameterSpec(this.data));
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            }

            byte[] encryptedPixelData = cipher.doFinal(pixelData);

            byte[] encryptedData = new byte[header.length + encryptedPixelData.length];

            System.arraycopy(header, 0, encryptedData, 0, header.length);
            System.arraycopy(encryptedPixelData, 0, encryptedData, header.length, encryptedPixelData.length);

            Writer writer = new Writer(getOutputFileName());
            writer.writeFiles(encryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a secret key for encryption
     */
    private void generateKey() {
        try {
            byte[] keyBytes = getKey().getBytes();

            secretKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, ENCRYPTION_BASE_TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
