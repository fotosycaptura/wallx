/*
 * enc.java
 *
 * Created on 4 de noviembre de 2004, 10:33
 */

package xcx;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;
import javax.imageio.ImageIO;

/**
 *
 * @author  xavierx
 */
public class enc{
    private int m_quality;
    
    public void make(String fileName, int newSize, String attach, boolean thumb) {
        try {
            String origFileName = fileName;
            File origImgFile = new File(origFileName);
            String newFileName = attach + File.separator + origImgFile.getName();
            
            // lee imagen
            BufferedImage origImage = ImageIO.read(origImgFile);
            BufferedImage resizedImage = null;
            
            // escala imagen
            int origImageWidth = origImage.getWidth(null);
            int origImageHeight = origImage.getHeight(null);
            
            double tempHeight = origImageHeight * 1.0;
            double tempWidth = origImageWidth * 1.0;
            double aspectRatio = tempWidth / tempHeight;
            
            // Cálculo de transformación
            tempHeight = newSize * 1.0;
            tempWidth = tempHeight * aspectRatio;
            
            int resizeImageWidth = (int) Math.round(tempWidth);
            int resizeImageHeight = (int) Math.round(tempHeight);
            
            resizedImage = new BufferedImage(resizeImageWidth, resizeImageHeight, Image.SCALE_SMOOTH);
            
            // Copia la imagen  al buffered image
            Graphics g = resizedImage.createGraphics();
            g.drawImage(origImage, 0, 0, resizeImageWidth, resizeImageHeight, null);
            //prepara la salida.
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFileName));
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(resizedImage);
            if (m_quality > 100 || m_quality < 1) {
                m_quality = 75; //default
            }
            param.setQuality((float) m_quality / 100.0f, false);
            encoder.setJPEGEncodeParam(param);
            encoder.encode(resizedImage);
            
        }
        catch (Exception runtimeException) {
            System.out.println("Exception while resizing file.");
            runtimeException.printStackTrace();
        }
    }//make
    
    /** Creates a new instance of enc */
    public enc() {
    }
    
}
