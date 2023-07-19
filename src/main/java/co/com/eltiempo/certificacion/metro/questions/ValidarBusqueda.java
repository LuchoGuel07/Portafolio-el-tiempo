package co.com.eltiempo.certificacion.metro.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.eltiempo.certificacion.metro.userinterfaces.HomePage.VALIDATION;

public class ValidarBusqueda implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {

        return VALIDATION.resolveFor(actor).isVisible();
    }

    public static ValidarBusqueda exitosa(){
        return new ValidarBusqueda();
    }
}
