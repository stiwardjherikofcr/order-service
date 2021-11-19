package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionBloqueadoPorAdministracion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionBloqueadoPorAdministracion(String mensaje) {
        super(mensaje);
    }
}
