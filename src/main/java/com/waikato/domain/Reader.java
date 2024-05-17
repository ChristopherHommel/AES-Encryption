package main.java.com.waikato.domain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reads files from the resources directory
 */
public class Reader {

    private static final String IMAGE_EXTENSION = "bmp";
    private static final String IMAGE_FILE = "Image-Assignment2" + "." + IMAGE_EXTENSION;
    private static final String KEY_FILE = "key.txt";

    private byte[] fileData;
    private String key;

    public Reader()
    {

    }

    /**
     * Read our resources
     */
    public void readFiles()
    {
        readImage();
        readKey();
    }

    /**
     * Read the file from the resources directory
     */
    private void readImage() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(IMAGE_FILE)) {
            if (inputStream == null) {
                setFileData(new byte[0]);
                return;
            }

            BufferedImage bufferedImage = ImageIO.read(inputStream);
            if (bufferedImage == null) {
                setFileData(new byte[0]);
                return;
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, IMAGE_EXTENSION, outputStream);
            setFileData(outputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            setFileData(new byte[0]);
        }
    }

    /**
     * Read the key from the resources directory
     */
    private void readKey() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(KEY_FILE)) {
            if (inputStream == null) {
                setKey("");
            } else {
                setKey(new String(inputStream.readAllBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            setKey("");
        }
    }

    public byte[] getFileData()
    {
        return fileData;
    }

    public void setFileData(byte[] fileData)
    {
        this.fileData = fileData;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
