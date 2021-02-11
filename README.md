# wallx
Este es un programa encargado de realizar el cambio en forma aleatoria del fondo de pantalla.

Esta aplicación fue creada en el año 2004.

Fue pensado inicialmente para Linux, en ese entonces al ingresar a un entorno gráfico, no existía alguna herramienta al menos que conociera en esos años, para cambiar el fondo de pantalla de manera aleatoria en cada inicio de sesión, por lo que se me ocurrió realizar esta aplicación para ello.

Tiene dos modos de operación:
* Consola
* GUI

Si se realiza la instrucción siguiente
> java -jar wallx.jar --help

se desplegará lo siguiente:

Wall X es un programa diseñado para realizar un cambio
aleatorio de Wallpaper en cada inicio del sistema.
Su sintáxis es la siguiente:  
wallx --help    : Muestra esta ayuda  
wallx -version  : Muestra la versión del programa  
wallx -gui      : Inicia la aplicación en modo gráfico  
wallx -cw       : Realiza el cambio aleatorio de wallpaper en modo texto  
wallx -cfg OSX  : Crea el archivo de configuración para wallx, donde OSX equivale  
                  a las siguientes opciones: 1 y 2, donde 1=Linux y 2=Windows

# Configuración en Linux
La instalación es sencilla, bastará con contar con Java para funcionar.
Se debe de copiar en alguna carpeta o directorio, dejar como servicio y que ejecute las sentencias
> java -jar wallx.jar -cw

Cada vez que se inicie el sistema e inicie el servicio, se cambiará la imagen wallx.jpg. Posteriormente, en el perfil del usuario, se debe de crear un enlace duro con el comando ln para que apunte al archivo de imagen.

Si mal no recuerdo eso era todo.

Esta aplicación la liberé en el 2004 y desde entonces no ha tenido mantenciones ni mejoras, se pueden mejorar muchas cosas, pero no se si a estas alturas sea necesario, dado que deben de existir mejores alternativas.
