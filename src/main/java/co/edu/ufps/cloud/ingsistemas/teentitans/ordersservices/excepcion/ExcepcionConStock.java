package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionConStock extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionConStock(String mensaje) {
        super(mensaje);
    }
}
