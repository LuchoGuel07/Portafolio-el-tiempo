package co.com.eltiempo.certificacion.metro.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co.com.eltiempo.certificacion.metro",
        features = "src/test/resources/features/inicio_sesion.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class InicioSesionRunner {
}
