package co.com.eltiempo.certificacion.metro.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {
    public static final Target PRECIO_DESDE = Target.the("Campo para ingresar el precio minimo").locatedBy("(//input[@class='sc-cvbbAY eNavcQ form-control'])[2]");
    public static final Target PRECIO_HASTA = Target.the("Campo para ingresar el precio maximo").locatedBy("(//input[@class='sc-cvbbAY eNavcQ form-control'])[3]");
    public static final Target FILTRAR_PRECIOS = Target.the("Botón para filtrar precios").located(By.id("filter-price"));
    public static final Target BANIOS = Target.the("Seleccionar la cantidad de baños que requiere").locatedBy("(//label[@class='sc-jAaTju bPqVtc Checkbox-qins2c-0 fHdbrH custom-radiobox custom-control custom-checkbox'][{0}])");
    public static final Target AREA_DESDE = Target.the("Campo para ingresar el area minima").locatedBy("(//div[@class='m2-select__value-container css-1hwfws3'])[2]");
    public static final Target CAMPO_AREA = Target.the("Opciones del area").locatedBy("//*[contains(text(),'{0}')]");
    public static final Target AREA_HASTA = Target.the("Campo para ingresar el area maxima").locatedBy("(//div[@class='m2-select__value-container css-1hwfws3'])[2]");
    public static final Target PRIMER_RESULTADO = Target.the("Primer resultado de la busqueda").locatedBy("//h3[@class=\"sc-ckVGcZ cFCiUO font-weight-light card-title\"]");
    public static final Target PRECIO_RESULTADO = Target.the("Precio del primer inmueble de los resultados").locatedBy("(//h3[@class=\"H3-sc-89yvsz-0 eovJcI\"])[1]");
    public static final Target METROS_RESULTADO = Target.the("Area del primer inmueble de los resultados").locatedBy("(//p[@class=\"card-text\"])[5]");
    public static final Target BANIOS_RESULTADO = Target.the("Baños del primer inmueble de los resultados").locatedBy("(//h2[@class=\"H2-kplljn-0 igCxTv vcenter-text card-text\"])[4]");


}
