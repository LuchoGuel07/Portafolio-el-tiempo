package co.com.eltiempo.certificacion.metro.stepdefinitions;

import co.com.eltiempo.certificacion.metro.userinterfaces.HomePage;
import co.com.eltiempo.certificacion.metro.util.GoogleDocsExcelPage;
import co.com.eltiempo.certificacion.metro.util.Helpers;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BusquedaArticuloStepDefinition {
    @Managed(driver = "chrome")
    private WebDriver herBrowser;
    Helpers helpers;
    private final Actor actor = Actor.named("Luis");
    GoogleDocsExcelPage googleDocsExcelPage;
    private final HomePage homepage = new HomePage();

    @Before
    public void setUp() {

        actor.can(
                BrowseTheWeb.with(herBrowser)
        );
    }

    @Given("ingreso a la pagina de portafolio {}")
    public void ingresoALaPaginaDePortafolioFila(int fila, DataTable datosExcel) {
        googleDocsExcelPage.obtenerDataDrivenExcelOnline(fila, datosExcel);
        actor.wasAbleTo(
                Open.browserOn(homepage)
        );
    }

    @When("realizo una busqueda en portafolio")
    public void realizoUnaBusquedaEnPortafolio() {
        actor.attemptsTo(
                Click.on(HomePage.BUSCADOR),
                SendKeys.of(Helpers.data.get("Busqueda")).into(HomePage.BUSCADOR_INPUT),
                //press Enter key
                Hit.the(Keys.ENTER).into(HomePage.BUSCADOR_INPUT)

        );
    }

    @Then("puedo navegar entre dos resultados de portafolio")
    public void puedoNavegarEntreDosResultadosDePortafolio() {

    }

}
