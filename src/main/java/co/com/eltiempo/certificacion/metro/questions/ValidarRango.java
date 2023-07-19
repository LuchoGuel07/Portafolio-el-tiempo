package co.com.eltiempo.certificacion.metro.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarRango implements Question<Boolean> {

    private final int valorInicial;
    private final int valorFinal;
    private final int validarDato;


    public ValidarRango(int valorInicial, int valorFinal, int validarDato) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.validarDato = validarDato;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return validarDato >= valorInicial && validarDato <= valorFinal;
    }
    public static ValidarRango delDato(int valorInicial, int valorFinal, int validarDato){
        return new ValidarRango(valorInicial,valorFinal,validarDato);
    }
}

