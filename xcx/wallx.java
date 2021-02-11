/***********************************************************************
 * remox: wallx. La X es por mi lindo nick XCX.    *
 *  Este programa asi como su documentación y código fuente se atienen  *
 * a la licencia publica GNU, adjunta en ingles con esta distribución.  *
 *           Puede encontrarse copia en http://www.gnu.org              *
 ************************************************************************
 * wallx: por XCX
 * Este es un programa encargado de realizar el cambio en forma aleatoria del
 * fondo de pantalla.
 * Utiliza wallx.properties como archivo principal de configuracion.
 */
package xcx;

import java.io.*;
import java.util.*;
import java.nio.channels.*;

public class wallx implements Serializable{
    private String dirActual;
    private String version;
    private String ext1;
    private Vector listado;
    private String archivoReal;
    
    public wallx(){
        dirActual = new String("./wallx");
        version = new String("0.8.0");
	//Por defecto, se ocupa extensión jpg, nativo en linux
        ext1 = new String("jpg");
	//El archivo de configuración
        archivoReal = new String("wallx.properties");
    }//constructor
    
    private String getArchivoReal(){
        return (this.archivoReal);
    }//getArchivoReal
    
    public void setDirActual(String dirActual){
        this.dirActual = dirActual;
    }//if
    
    public String getDirActual(){
        return (this.dirActual);
    }//getDirActual
    
    public void setExt1(String ext1){
        this.ext1 = ext1;
    }//setExt1
    
    public String getExt1(){
        return(this.ext1);
    }//getExt1
    
    public String getVersion(){
        return (this.version);
    }//getVersion
    
    public String leerConfig(){
        String extension = null;
        try{
            Properties configuracion = new Properties();
            FileInputStream f = new FileInputStream(getDirActual() + File.separator + getArchivoReal());
            configuracion.load(f); 
            extension = configuracion.getProperty("extension");
            f.close();
            return (extension);
        }catch(IOException ioe){
            //System.out.println("Error al leerConfig-> " + ioe);
            return (extension);
        }//try
    }//leerConfig
    
    public boolean crearConfig(String extension){
        try{
            Properties configuracion = new Properties();
            configuracion.put("extension", extension);
            File f = new File(getDirActual() + File.separator + getArchivoReal());
            f.delete();
            FileOutputStream out = new FileOutputStream(getDirActual() + File.separator + getArchivoReal());
            //Escribe la configuración y un encabezado para el archivo de configuración.
            configuracion.store(out, "wallxconfig");
            out.close();
            return true;
        }catch(IOException ioe){
            System.out.println("Error al crearConfig-> " + ioe);
            return false;
        }//try
    }//crearConfig
    
    public String crcDirWork(){
        String dirwork = System.getProperty("user.dir");
        //System.out.println(wx.getDirActual().indexOf("wallx"));
        if (dirwork.indexOf("wallx") < 1){
            setDirActual(dirwork + File.separator + "wallx");
            dirwork = getDirActual();
        }//if
        return (dirwork);
    }//crcDirwork
    
    public boolean InicializarConfig(){
        /* Método encargado de leer o crear el archivo de configuración
         * deteniendo la ejecución en caso de algun error, como por ejemplo
         * que el archivo no exista. que vendría a ser siempre en la primera
         * ejecución del programa.
         */
        setDirActual(crcDirWork());
        String extension = new String();
        extension = leerConfig();
        if (extension != null){
            setExt1(extension);
            return true;
        }else{
            System.out.println("La configuración inicial no ha sido seteada");
            System.out.println("Ejecute wallx --help para más información");
            return false;
        }//if
    }//InicializarConfig
    
    public void creditos(){
        System.out.println("Idea original: XavierConX");
        System.out.println("Desarrollador: XavierConX");
        System.out.println("Diseño GUI: Adivinen");
        System.out.println("Diseño logo: ¿Quien más?");
        System.out.println("Aplicación Open Source y sujeta a GPL. (Vea licencia.txt para mas detalles)");
        System.out.println("Cualquier comentario, modificación, la agradezco a xavierconx@linuxmail.org");
    }//creditos

    public static void copia2(String origen, String destino) throws IOException{
     byte buffer[]= new byte[1024];  
      int cuenta;  
         FileInputStream fis = new FileInputStream(origen);  
         FileOutputStream fos = new FileOutputStream(destino);  
         while((cuenta=fis.read(buffer))>0)
            fos.write(buffer);//,cuenta);
    }//copia2

    public static void copia(String nombreFuente, String nombreDestino) throws IOException {
        FileInputStream fis  = new FileInputStream(nombreFuente);
        FileOutputStream fos = new FileOutputStream(nombreDestino);
        FileChannel canalFuente  = fis.getChannel();
        FileChannel canalDestino = fos.getChannel();
        canalFuente.transferTo(0, canalFuente.size(), canalDestino);
        fis.close();
        fos.close();
    }//copia
    
    public void eliminar(String nombreFuente){
        File arch = new File(this.getDirActual() + File.separator + nombreFuente);
        arch.delete();
    }//eliminar
    
    public Vector ListaX(){
        Vector v = new Vector();
        File archivo = new File(getDirActual());
        String lista[] = archivo.list();
        if (lista != null){
            for (int i=0; i < lista.length; i++){
                if (lista[i].indexOf(ext1) > 1 && !lista[i].equalsIgnoreCase("wallx." + getExt1())){
                    v.addElement(new String(lista[i]));
                }//if
            }//for
        }//if
        return (v);
    }//ListaX
    
    public void tips(){
        System.out.println("wallx " + version + "  creado por XCX");
        System.out.println("");
        System.out.println("Wall X es un programa diseñado para realizar un cambio");
        System.out.println("aleatorio de Wallpaper en cada inicio del sistema.");
        System.out.println("Su sintáxis es la siguiente:");
        System.out.println("wallx --help    : Muestra esta ayuda");
        System.out.println("wallx -version  : Muestra la versión del programa");
        System.out.println("wallx -gui      : Inicia la aplicación en modo gráfico");
        System.out.println("wallx -cw       : Realiza el cambio aleatorio de wallpaper en modo texto");
        System.out.println("wallx -cfg OSX  : Crea el archivo de configuración para wallx, donde OSX equivale");
        System.out.println("                  a las siguientes opciones: 1 y 2, donde 1=Linux y 2=Windows");
    }//tips
    
    public void gui(){
        FrameSis fs = new FrameSis();
        fs.setSize(new java.awt.Dimension(425,297));
        fs.setTitle("GUI para WallX Versión " + getVersion());
        fs.validate();
        fs.show();
    }//gui
    
    public void cambiarWall(){
        Vector v = ListaX();
        int total = v.size();
        Random r = new Random();
        r.setSeed(r.nextLong());
        int elegido = 0;
        elegido = r.nextInt(total);
        String archchoose = getDirActual() + File.separator + (String)v.get(elegido);
        String estWall = getDirActual() + File.separator + "wallx." + ext1;
        if (archchoose.equalsIgnoreCase(estWall)){
            return;
        }//if
        try{
            copia2(archchoose, estWall);
        }catch(IOException ioe){
            System.out.println("Error de E/S cambiarWall->: " + ioe);
        }
    }//cambiarWall
    
    public boolean verifyParam(String parametros[]){
        boolean retorno = false;
        boolean configLoaded = InicializarConfig();
        if(parametros.length > 0){
            if (parametros[0].equals("--help")){
                tips();
                creditos();
                return (retorno);
            }//if
            if (parametros[0].equals("-version")){
                creditos();
                return (retorno);
            }//if
            if (configLoaded && parametros[0].equals("-gui")){
                gui();
                return (retorno);
            }//if
            if (configLoaded && parametros[0].equals("-cw")){
                cambiarWall();
                return (retorno);
            }//if
            /* Si la configuración no ha sido cargada y el parámetro
             * es igual a cfg, entonces se deberá crear la configuración.
             */
            if (parametros[0].equals("-cfg")){
                if (parametros[1] != null && parametros[1].equals("1")){
                    crearConfig("jpg");
                    System.out.println("¡Configuración seteada!");
                }//if
                if (parametros[1] != null && parametros[1].equals("2")){
                    crearConfig("bmp");
                    System.out.println("¡Configuración seteada!");
                }//if
                return (retorno);
            }//if
            return (retorno);
        }else{
            return (retorno);
        }//if
    }//verifyParam
    
    public static void main(String args[]){
        wallx fx = new wallx();
        System.out.println("WallX version " + fx.getVersion());
        fx.verifyParam(args);
    }//main
}//remox
