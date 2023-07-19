package co.com.eltiempo.certificacion.metro.exceptions;

public class GeneralExceptions extends AssertionError{
    public GeneralExceptions(String message, Throwable cause){
        super(message,cause);
    }
}
