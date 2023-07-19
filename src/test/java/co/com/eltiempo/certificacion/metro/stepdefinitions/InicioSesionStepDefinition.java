package co.com.eltiempo.certificacion.metro.stepdefinitions;

import co.com.eltiempo.certificacion.metro.questions.ValidarBusqueda;
import co.com.eltiempo.certificacion.metro.tasks.IniciarSesion;
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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class InicioSesionStepDefinition {

    @Managed(driver = "chrome")
    private WebDriver herBrowser;
    private final Actor actor = Actor.named("Luis");
    GoogleDocsExcelPage googleDocsExcelPage;
    private final HomePage homepage = new HomePage();

    @Before
    public void setUp() {
        actor.can(BrowseTheWeb.with(herBrowser));
    }

    @Given("ingreso a la pagina de login de portafolio {int}")
    public void ingresoALaPaginaDeLoginDePortafolioFila(int fila, DataTable datosExcel) {
        googleDocsExcelPage.obtenerDataDrivenExcelOnline(fila, datosExcel);
        actor.wasAbleTo(
                Open.browserOn(homepage)
        );
    }

    @When("ingreso los datos de logueo de portafolio")
    public void ingresoLosDatosDeLogueoDePortafolio() {
        actor.attemptsTo(
                Click.on(HomePage.INICIAR_SESION),
                IniciarSesion.conLosDatos(
                        Helpers.data.get("Usuario"),
                        Helpers.data.get("Contrasena")
                )
                //Click.on(HomePage.MENU_USUARIO)

        );
    }

    @Then("puede validar la funcionalidad de logueo de portafolio")
    public void puedeValidarLaFuncionalidadDeLoguedoDePortafolio() {
        actor.should(seeThat(ValidarBusqueda.exitosa()));
    }
}
