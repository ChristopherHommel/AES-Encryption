package main.java.com.waikato.domain;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ByteArrayInputStream;

/**
 * Writes file to the file system
 */
public class Writer {

    private static final String OUT_EXTENSION = "jpg";
    private static final String OUT_DIRECTORY = "out";

    private final String fileName;

    public Writer(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Write the file to the file system
     *
     * @param data the data to write
     */
    public void writeFiles(byte[] data)
    {
        writeToJpegFile(data);
    }

    /**
     * Write the data to a jpeg file
     *
     * @param data the data to write
     */
    private void writeToJpegFile(byte[] data) {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            BufferedImage outputStream = ImageIO.read(inputStream);

            Path outputPath = Paths.get(OUT_DIRECTORY);
            if (!Files.exists(outputPath)) {
                Files.createDirectories(outputPath);
            }

            String outputFilePath = OUT_DIRECTORY + "/" + fileName + "." + OUT_EXTENSION;

            ImageIO.write(outputStream, OUT_EXTENSION, new File(outputFilePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
