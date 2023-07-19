package co.com.eltiempo.certificacion.metro.util;

public class EnvironmentNotFoundException extends Exception {
    public EnvironmentNotFoundException() {
        super("The environment could not be found");
    }
}
