package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionCantidadInsuficiente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCantidadInsuficiente(String mensaje) {
        super(mensaje);
    }
}
