package co.com.eltiempo.certificacion.metro.tasks;

import co.com.eltiempo.certificacion.metro.util.Helpers;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static co.com.eltiempo.certificacion.metro.userinterfaces.LoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IniciarSesion implements Task {
Helpers helpers = new Helpers();
    private final String usuario;
    private final String contrasena;
    String argumentsClick = "arguments[0].click();";

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.getDriver().switchTo().frame("iframe_boletines");
        actor.attemptsTo(
                Scroll.to(CORREO_ELECTRONICO),
                Click.on(CORREO_ELECTRONICO),
                SendKeys.of(usuario).into(CORREO_ELECTRONICO),
                Click.on(CONTRASENA),
                SendKeys.of(contrasena).into(CONTRASENA),
                //press Enter key
//                Hit.the(Keys.ENTER).into(CONTRASENA),
//                //press Tab key
//                Hit.the(Keys.TAB).into(CONTRASENA),
//                isClickable(INICIAR_SESION),
//                Hit.the(Keys.ENTER).keyIn(INICIAR_SESION)
//                SendKeys.of(Keys.TAB).into(CONTRASENA),
                Click.on(INICIAR_SESION)

        );
        Serenity.getDriver().switchTo().defaultContent();
        helpers.esperaSelenium(3);
    }

    public static IniciarSesion conLosDatos(String usuario, String contrasena){
        return instrumented(IniciarSesion.class,usuario,contrasena);
    }
}
