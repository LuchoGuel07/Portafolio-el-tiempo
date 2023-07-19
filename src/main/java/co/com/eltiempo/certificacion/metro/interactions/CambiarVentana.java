package co.com.eltiempo.certificacion.metro.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CambiarVentana implements Interaction {

    private final WebDriver driver;

    public CambiarVentana(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String ventanaorigen = driver.getWindowHandle();

        driver.close();
        for (String ventanaHandle: driver.getWindowHandles()){
            if (!ventanaorigen.contentEquals(ventanaHandle)){
                driver.switchTo().window(ventanaHandle);
                break;
            }
        }
    }

    public static CambiarVentana delNavegador(WebDriver driver){
        return instrumented(CambiarVentana.class,driver);
    }
}
