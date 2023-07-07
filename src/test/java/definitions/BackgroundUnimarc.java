package definitions;

import constants.Navegador;
import driver.DriverContext;
import driver.NavSelector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.GooglePage;
import utils.MetodosGenericos;

import static constants.Constant.URL_GOOGLE;
import static org.junit.Assert.assertEquals;

public class BackgroundGoogle {

    GooglePage googlePage = new GooglePage();
    @Given("Ingresar a google")
    public void ingresarAGoogle() {
        String navegador = System.getProperty("nav", "default");
        Navegador nav = NavSelector.seleccionNavegador(navegador);
        DriverContext.setUp(nav, URL_GOOGLE);
        MetodosGenericos.esperar(2);
        String url = DriverContext.getDriver().getCurrentUrl();
        assertEquals(URL_GOOGLE, url);
    }



}
