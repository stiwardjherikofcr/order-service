package co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.error;


import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionCantidadInsuficiente;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionConStock;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionDuplicidad;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionFinDeMes;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionLongitudValor;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionObjectoNoEncontrado;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionSinDatos;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionValorInvalido;
import co.edu.ufps.cloud.ingsistemas.teentitans.ordersservices.excepcion.ExcepcionValorObligatorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorError.class);

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "OcurriÃ³ un error favor contactar al administrador.";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {
        CODIGOS_ESTADO.put(ExcepcionLongitudValor.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionValorInvalido.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionSinDatos.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExcepcionValorObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionDuplicidad.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionConStock.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        CODIGOS_ESTADO.put(ExcepcionObjectoNoEncontrado.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExcepcionFinDeMes.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionCantidadInsuficiente.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());

        //en caso de tener otra excepcion matricularla aca
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            LOGGER_ERROR.error(excepcionNombre, exception);
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultado;
    }


}