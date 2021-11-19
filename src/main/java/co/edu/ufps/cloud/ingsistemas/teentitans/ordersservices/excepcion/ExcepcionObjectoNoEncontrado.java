package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionObjectoNoEncontrado  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionObjectoNoEncontrado(String message) {
        super(message);
    }
}
