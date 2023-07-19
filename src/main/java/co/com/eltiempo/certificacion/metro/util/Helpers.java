package co.com.eltiempo.certificacion.metro.util;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers extends PageObject {
	
	Logger logger = Logger.getLogger( Helpers.class.getName());
	public static Map<String, String> data = new HashMap<>();
	final String CLICK_JAVASCRIPT = "arguments[0].click();";

	public void esperaSelenium(int seconds) {
		try {
			Thread.sleep(seconds * (long) 1000);
		} catch (Exception e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}

	public void carguesAutoIT(String ruta) {
		try {
			Runtime.getRuntime().exec(ruta);
		} catch (Exception e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}

	public void scrollMobile(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(100, 200).clickAndHold().moveByOffset(150, 400).release().build().perform();
	}

	public void abirUrlElEmpleo(String pais) {
		open();
		Serenity.getDriver().manage().deleteAllCookies();
		Serenity.getDriver().manage().window().maximize();
		String urlEjecutada= Serenity.getDriver().getCurrentUrl();
		switch (pais.toLowerCase()){
			case "co":
				openUrl(urlEjecutada+"co/");
				break;
			default:
				throw new IllegalStateException("Inesperado valor pais: " + pais);
		}

	}

	public void posicionarObjeto(WebElementFacade elementoPantalla){
		((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(false);"
				,elementoPantalla);

	}
	public void javaScriptClick(WebElementFacade elemento){
		((JavascriptExecutor) this.getDriver()).executeScript(CLICK_JAVASCRIPT,
				elemento);
	}
}


