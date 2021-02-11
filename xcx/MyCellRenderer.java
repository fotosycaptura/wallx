package xcx;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;

class MyCellRenderer extends JLabel implements ListCellRenderer{
    //final static ImageIcon longIcon = new ImageIcon("long.jpg");
    //final static ImageIcon shortIcon = new ImageIcon("short.jpg");
    Image img;
    private String ruta;
    private boolean hacer;
    // This is the only method defined by ListCellRenderer.
    // We just reconfigure the JLabel each time we're called.
    
    public void setHacer(boolean hacer){
        this.hacer = hacer;
    }//setHacer
    
    public boolean getHacer(){
        return this.hacer;
    }//getHacer
    
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        String s = value.toString();
        setText(s);
        img = Toolkit.getDefaultToolkit().getImage(ruta + File.separator + "thumbs" + File.separator + s);
        // Se utilzia un objeto MediaTracker para bloquear la tarea hasta
        // que la imagen se haya cargado o hayan transcurrido 10 segundos
        // desde que se inicia la carga
        MediaTracker tracker = new MediaTracker( this );
        tracker.addImage(img,1);
        try {
            if( !tracker.waitForID( 1,10000 ) ) {
                System.out.println("Se ha superado el tiempo de carga de una imágen. Máximo 10 seg.");
                System.exit( 1 );
            }//if
        }catch( InterruptedException e ) {
            System.out.println( e );
        }//try
        //img = img.getScaledInstance(70, 40, 4);
        setIcon(new ImageIcon(img));
        //setIcon((s.length() > 10) ? longIcon : shortIcon);
        //setIcon(new ImageIcon(ruta + File.separator + "thumbs" + File.separator + s));
        //setIcon(new ImageIcon(ruta + File.separator + s));
        //createImage(40,40);
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }//if
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
    
    
    public MyCellRenderer(String ruta){
        this.ruta = ruta;
    }
    public static void main(String args[]){
    }
}
