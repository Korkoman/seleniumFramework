package utilityLayer;

public enum exceptionMessages {

    //Errores de Driver
    WEBDRIVEREXCEPTION("Se ha presentado un error con el Driver."),
    SESSIONNNOTCREATEDEXCEPTION("NO se ha podido crear la sesión."),
    INVALIDSESSIONEXCEPTION("El ID de la sesión es inválido."),
    NOSUCHDRIVEREXCEPTION("El WebDriver referido no existe."),
    CONNECTIONCLOSEDEXCEPTION("La conexión ha caducado."),
    REMOTEDRIVERSERVEREXCEPTION("Error con el servidor WebDriver"),

    //Errores de interacción con elementos
    NOSUCHELEMENTEXCEPTION("El elemento no existe."),
    ELEMENTNOTVISIBLEEXCEPTION("El elemento no se encuentra visible."),
    ELEMENTNOTSELECTABLEEXCEPTION("EL elemento no se puede seleccionar."),
    INVALIDELEMENTSTATEEXCEPTION("El estado de este elemento no permite interacción."),
    STALEELEMENTREFERENCEEXCEPTION("El elemento referenciado ya no es válido."),
    ELEMENTCLICKINTERCEPTEDEXCEPTION("Hay otro elemento que bloquea el click a este elemento."),
    NOSUCHATTRIBUTEEXCEPTION("El atributo especificado no está asociado a este elemento."),
    INVALIDSELECTOREXCEPTION("El selector especificado no es válido"),

    //Errores de tiempo
    TIMEOUTEXCEPTION("Se ha superado el tiempo de espera."),
    NOSUCHWINDOWEXCEPTION("La ventana no existe."),
    NOSUCHFRAMEEXCEPTION("El marco referenciado no existe."),
    NOALERTPRESENTEXCEPTION("No existen alertas."),

    //Errores de navegación
    INVALIDARGUMENTEXCEPTION("Los argumentos suministrados no son válidos."),
    JSEXCEPTION("Error en el script de Javascript"),
    MOVETARGETOUTOFBOUNDS("La ubicación a la que se desplaza está fuera del límite"),

    //Errores relacionados con la seguridad

    INSECURECERTIFICATEEXCEPTION("Ha sucedido un error en la seguridad del certificado."),
    INVALIDCOOKIEDOMAINEXCEPTION("Está intentando agregar una cookie a un dominio errado"),
    UNABLETOSETCOOKIEEXCEPTION("No se pudo establecer la cookie");

    private String eMessage;
    exceptionMessages(String eMessgae){
        this.eMessage = eMessgae;
    }

    public String geteMessage(){
        return eMessage;
    }
}
