package utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;


public class ImageCompression {

      
        public static BufferedImage compressImage(BufferedImage bi, float quality) throws IOException {
                ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();
                ImageWriteParam iwp = writer.getDefaultWriteParam();
                iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                iwp.setCompressionQuality(quality);

                byte[] imageBytes = null;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
                writer.setOutput(ios);

                IIOImage iio = new IIOImage(bi, null, null);

                writer.write(null, iio, iwp);

                imageBytes = baos.toByteArray();

                return ImageIO.read(new ByteArrayInputStream(imageBytes));
        }
}
