package it.eng.tim.costi.model.exception;

/**
 * Created by alongo on 30/04/18.
 */
public class GenericException extends RuntimeException {

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
