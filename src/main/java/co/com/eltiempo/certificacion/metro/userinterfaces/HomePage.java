package co.com.eltiempo.certificacion.metro.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;


@DefaultUrl("https://beta.portafolio.co/")

public class HomePage extends PageObject {
    public static final Target INICIAR_SESION = Target.the("Boton para iniciar sesion")
            .locatedBy("//*[@id=\"btn_iniciar_sesion\"]");
    public static final Target MENU_USUARIO = Target.the("Campo para validar las opciones de usuario").
            locatedBy("//*[@id=\"user_logued\"]");
    public static final Target VALIDATION = Target.the("Validacion de envio de formulario")
            .locatedBy("//p[@class=\"menu__header__titulo\"]");
    public static final Target BUSCADOR = Target.the("Campo para buscar articulos")
            .locatedBy("//*[@id=\"btn_buscador_icon\"]");
    public static final Target BUSCADOR_INPUT = Target.the("Campo para buscar articulos")
            .locatedBy("//*[@id=\"buscador_form\"]/input");
    public static final Target RECIBIR_INFORMACION = Target.the("Cuadro de texto para aceptar recibir informacion")
            .locatedBy("//*[@id=\"onesignal-slidedown-container\"]");
    public static final Target CERRAR_RECIBIR_INFORMACION = Target.the("Boton para cerrar cuadro de texto para recibir informacion")
            .locatedBy("//*[@id=\"onesignal-slidedown-cancel-button\"]");
    public static final Target ANUNCIO_BARRA_INFERIOR = Target.the("Boton para cerrar anuncio de la barra inferior")
            .locatedBy("//*[@id=\"gpt-slot-barra-flotante-inferior-close-btn\"]/img");
}
