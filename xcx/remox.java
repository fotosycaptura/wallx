/***********************************************************************
 * remox: REnombrador MasivO por XCX. La X es por mi lindo nick XCX.    *
 *  Este programa asi como su documentación y código fuente se atienen  *
 * a la licencia publica GNU, adjunta en ingles con esta distribución.  *
 *           Puede encontrarse copia en http://www.gnu.org              *
 ************************************************************************
 * remox: REnombrador MasivO por XCX
 * Este es un programa encargado de realizar renombrado de archivos en serie
 * No he querido incluirlo en un package debido a que todavía no lo he pensado
 * para uso con gui.
 */
package xcx;
import java.io.*;
import java.util.*;

public class remox{
    private String dirActual;
    private String version;
    private String ext1;
    private String ext2;
    private String nombre;
    private String count;
    private Vector listado;
    
    public remox(){
        dirActual = new String("./");
        version = new String("1.0");
        ext1 = new String();
        ext2 = new String();
        nombre = new String();
        count = new String("0");
        listado = new Vector();
    }//constructor
    
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
    
    public void setExt2(String ext2){
        this.ext2 = ext2;
    }//setExt2
    
    public String getExt2(){
        return(this.ext2);
    }//getExt2
    
    public String getNombre(){
        return(this.nombre);
    }//getNombre
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }//setNombre
    
    public void setContador(String contador){
        this.count = contador;
    }//setContador
    
    public String getContador(){
        return(this.count);
    }//getContador
    
    public String getVersion(){
        return (this.version);
    }//getVersion
    
    public void setListado(Vector ls){
        this.listado = ls;
    }//setListado
    public Vector getListado(){
        return (this.listado);
    }//getListado
    
    public void Renombrar(Vector listado){
        int cont = Integer.parseInt(getContador());
        String ext = new String();
        String newNombre = new String();
        newNombre = getNombre();
        if (getExt2() == null || getExt2().equals("")){
            ext = getExt1();
        }else{
            ext = getExt2();
        }//if
        int totalRenombrado = 0;
        //System.out.println("Entrando a picar...");
        for(int i=0; i < listado.size(); i++){
            String narchivo = (String)listado.get(i);
            if (!narchivo.equalsIgnoreCase("wallx." + getExt1())){
                File archivo = new File(getDirActual() + File.separator + narchivo);
                String serie = new String();
                String nomAPoner = new String();
                int tope = (String.valueOf(listado.size())).length();
                nomAPoner = String.valueOf(cont);
                for (int j=1; j < tope; j++){
                    if (((String.valueOf(cont)).length()) < tope && nomAPoner.length() < tope){
                        nomAPoner = "0" + nomAPoner;
                    }//if
                }//for
                nomAPoner = newNombre + nomAPoner + "." + ext;
                //System.out.println("Renombrando " + narchivo + " a " + nomAPoner);
                File archivo2 = new File(getDirActual() + File.separator + nomAPoner);
                if(!archivo2.exists()){
                    archivo.renameTo(archivo2);
                    cont++;
                    totalRenombrado++;
                }else{
                    //System.out.println("Error al renombrar, ya existe otro archivo con ese nombre.\n Abortando...");
                    break;
                }//if
            }//if
        }//for
        //System.out.println("Listo! Archivos renombrados: " + totalRenombrado);
    }//Renombrar
    
    public void creditos(){
        System.out.println("Idea: XavierConX");
        System.out.println("Desarrollador: XavierConX");
        System.out.println("Aplicación Open Source y sujeta a GPL. (Vea licencia.txt para mas detalles)");
        System.out.println("Cualquier comentario, modificación, la agradezco a xavierconx@linuxmail.org");
    }//creditos
    
    public void renombrar(String listado[]){
        int cont = Integer.parseInt(getContador());
        String ext = new String();
        String newNombre = new String();
        newNombre = getNombre();
        if (getExt2() == null || getExt2().equals("")){
            ext = getExt1();
        }else{
            ext = getExt2();
        }//if
        int totalRenombrado = 0;
        System.out.println("Entrando a picar...");
        for(int i=0; i < listado.length; i++){
            if (listado[i].lastIndexOf(getExt1()) > 0){
                String narchivo = listado[i];
                File archivo = new File(narchivo);
                String serie = new String();
                String nomAPoner = new String();
                int tope = (String.valueOf(listado.length)).length();
                nomAPoner = String.valueOf(cont);
                for (int j=1; j < tope; j++){
                    if (((String.valueOf(cont)).length()) < tope && nomAPoner.length() < tope){
                        nomAPoner = "0" + nomAPoner;
                    }//if
                }//for
                nomAPoner = newNombre + nomAPoner + "." + ext;
                //System.out.println("Renombrando " + narchivo + " a " + nomAPoner);
                File archivo2 = new File(nomAPoner);
                if(!archivo2.exists()){
                    archivo.renameTo(archivo2);
                    cont++;
                    totalRenombrado++;
                }else{
                    System.out.println("Error al renombrar, ya existe otro archivo con ese nombre.\n Abortando...");
                    break;
                }//if
            }//if
        }//for
        System.out.println("Listo! Archivos renombrados: " + totalRenombrado);
    }//renombrar
    
    public String[] ListaX(){
        File archivo = new File(getDirActual());
        System.out.println("Archivos en total: " + archivo.list().length);
        String lista[] = archivo.list();
        return (lista);
    }//ListaX
    
    public void tips(){
        System.out.println("remox " + version + " : REnombrador MasivO by Xcx");
        System.out.println("Modo de uso: remox -x=ext1 -n=NewNombre -[c=Contador -y=ext2] --help --history");
        System.out.println("Donde: Contador es el número desde donde se desea comenzar.");
        System.out.println("ext1 y ext2 es la extensión sin . ni *");
        System.out.println("Si el parámetro -c es omitido, se comenzará desde 0");
        System.out.println("Si el parámetro -y es omitido, se añadirá la extensión puesta en el ");
        System.out.println("parámetro -x");
        System.out.println("-x y -n son parámetros necesarios");
        System.out.println("--help muestra esta ayuda");
        System.out.println("--history muestra una historia acerca de remox");
        System.out.println("");
    }//tips
    
    public void history(){
        System.out.println("REMOX " + version + " REnombrador MasivO by Xcx");
        System.out.println("La historia es corta y simple, requeria de un programa para renombrar");
        System.out.println("en forma masiva archivos que disponía en mi Sistema Operativo, que es por");
        System.out.println("supuesto, Linux, estuve averiguando acerca del comando rename, pero cada vez");
        System.out.println("que lo ejecutaba no siempre hacía lo que yo realmente necesitaba, en ocaciones");
        System.out.println("me borraba el primer archivo del directoro, y si lo volvia a ejecutar, lo mismo");
        System.out.println("Es por esto que a la fecha 13 de septiembre del año 2004, me decidi a crear una ");
        System.out.println("aplicación que permitiera resolver estas dificultades.");
        System.out.println("El porqué lo he liberado, es debido a que alguna otra persona necesite de algo");
        System.out.println("similar, así como yo lo estuve, además, siempre es bueno ayudar en la medida de que se");
        System.out.println("pueda con este potente sistema operativo.");
        System.out.println("El porqué desarrollé esta aplicación en java y no en gcc por ejemplo, fue por motivos");
        System.out.println("de comodidad, y porque si lo deseas, puedes compilarlo con gcj. ^_~");
    }//history
    
    public boolean verifyParam(String parametros[]){
        boolean retorno = false;
        if(parametros.length > 0){
            if (parametros[0].equals("--help")){
                tips();
                creditos();
                return (retorno);
            }//if
            if (parametros[0].equals("--history")){
                history();
                creditos();
                return (retorno);
            }//if
            if (parametros[0].equals("--version")){
                System.out.println("remox " + version + ".");
                creditos();
                return (retorno);
            }//if
            //Se supone que si no paso al if anterior, es debido a que la orden es mas
            //larga y por ende hay que verificar los parámetros
            for (int i=0; i < parametros.length; i++){
                StringTokenizer stk = new StringTokenizer(parametros[i], "=");
                if (stk.countTokens() == 2){
                    String trozo1 = stk.nextToken();
                    if (trozo1.equals("-x")) setExt1(stk.nextToken());
                    if (trozo1.equals("-n")) setNombre(stk.nextToken());
                    if (trozo1.equals("-c")) setContador(stk.nextToken());
                    if (trozo1.equals("-y")) setExt2(stk.nextToken());
                }else return (retorno);
            }//for
            if ((getNombre() == null || getNombre().equals("")) || (getExt1() == null || getExt1().equals(""))){
                retorno = false;
            }else{
                retorno = true;
            }//if
            return (retorno);
        }else{
            return (retorno);
        }//if
    }//verifyParam
    
    public static void main(String args[]){
        remox fx = new remox();
        if (fx.verifyParam(args)){
            System.out.println("remox versión " + fx.getVersion() + ". Un momento por favor... ");
            fx.renombrar(fx.ListaX());
        }else{
            System.out.println("Para mas detalles, escriba remox --help");
        }//if
    }//main
}//remox
