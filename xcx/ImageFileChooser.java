/*
 * PictureDialog.java
 * From Drawswf-1.2.7, http://www.bestsolution.at
 * Created on 10. Jänner 2003, 15:15
 */
package xcx;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
//import javax.swing.JFileChooser;

import xcx.ImageFilter;
/**
 *
 * @author  tom
 */
public class ImageFileChooser extends JFileChooser
{
    /** Creates a new instance of PictureDialog */
    public ImageFileChooser()
    {
        super();

        FilePreviewer previewer = new FilePreviewer(this);
        setAccessory( previewer );

        addChoosableFileFilter( new ImageFilter() );
    }

    public Image getSelectedImage() {
        return Toolkit.getDefaultToolkit().createImage(getSelectedFile().getPath());
    }
    public Image getSelectedImage(int w, int h) {
        return Toolkit.getDefaultToolkit().createImage(getSelectedFile().getPath()).getScaledInstance(w,h,Image.SCALE_FAST);
    }

}
