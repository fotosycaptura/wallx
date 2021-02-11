/*
 * FilePreviewer.java
 *
 * Created on 10. Jänner 2003, 15:04
 */
package xcx;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

import java.io.File;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;



/**
 *
 * @author  tom
 */
public class FilePreviewer extends JComponent implements PropertyChangeListener
{
    ImageIcon thumbnail_ = null;

    public FilePreviewer(JFileChooser fc)
    {
        setPreferredSize( new Dimension(100, 50) );
        fc.addPropertyChangeListener( this );
    }

    public void loadImage( File f )
    {
        if (f == null)
        {
            thumbnail_ = null;
        }
        else
        {
            ImageIcon tmpIcon = new ImageIcon(f.getPath());

            if(tmpIcon.getIconWidth() > 90)
            {
                thumbnail_ = new ImageIcon( tmpIcon.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT) );
            }
            else
            {
                thumbnail_ = tmpIcon;
            }
        }
    }

    public void propertyChange(PropertyChangeEvent e)
    {
        String prop = e.getPropertyName();

        if(prop == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
        {
            if( isShowing() )
            {
                loadImage((File) e.getNewValue());
                repaint();
            }
        }
    }

    public void paint(Graphics g)
    {
        if( thumbnail_ != null)
        {
            int x = getWidth()/2 - thumbnail_.getIconWidth()/2;
            int y = getHeight()/2 - thumbnail_.getIconHeight()/2;
            if(y < 0)
            {
                y = 0;
            }

            if(x < 5)
            {
                x = 5;
            }

            thumbnail_.paintIcon(this, g, x, y);
        }
    }
}
