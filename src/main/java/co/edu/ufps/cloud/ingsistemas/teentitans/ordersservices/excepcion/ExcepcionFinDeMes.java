package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionFinDeMes extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFinDeMes(String message) {
        super(message);
    }
}
