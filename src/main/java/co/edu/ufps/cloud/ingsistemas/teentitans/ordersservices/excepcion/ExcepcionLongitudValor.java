package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion;

public class ExcepcionLongitudValor extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionLongitudValor(String message) {
        super(message);
    }
}
