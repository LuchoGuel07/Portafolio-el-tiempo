package co.com.eltiempo.certificacion.metro.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
   public static final Target CORREO_ELECTRONICO = Target.the("Campo para ingresar el correo electronico")
           .located(By.id("username"));
    public static final Target CONTRASENA = Target.the("Campo para ingresar la contraseña")
            .locatedBy("//*[@id=\"password\"]");
    public static final Target MOSTRAR_CONTRASENA = Target.the("Boton para mostrar la contraseña")
            .locatedBy("//*[@id=\"login\"]/fieldset/div[1]/div[2]/span/label");
    public static final Target INICIAR_SESION = Target.the("Boton para iniciar sesion")
            .located(By.id("submitbutton"));


}
