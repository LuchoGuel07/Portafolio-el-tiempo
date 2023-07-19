package co.com.eltiempo.certificacion.metro.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.eltiempo.certificacion.metro.util.ConstantesBusqueda.*;

public class BusquedaCorrecta implements Question<Boolean> {

    private final int precioDesde;
    private final int preciohasta;
    private final int banios;
    private String areaDesde;
    private String areaHasta;

    public BusquedaCorrecta(int precioDesde, int preciohasta, int banios, String areaDesde, String areaHasta) {
        this.precioDesde = precioDesde;
        this.preciohasta = preciohasta;
        this.banios = banios;
        this.areaDesde = areaDesde;
        this.areaHasta = areaHasta;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int precio = Integer.parseInt(actor.recall(VALOR_INMUEBLE));
        System.out.println("El precio es:"+precio);
        int area = Integer.parseInt(actor.recall(AREA_INMUEBLE));
        int baniosInmueble = Integer.parseInt(actor.recall(BANIOS_INMUEBLE));
        areaDesde = areaDesde.replace(" m2","");
        int areaDesdeint = Integer.parseInt(areaDesde);
        areaHasta = areaHasta.replace(" m2","");
        int areaHastaint = Integer.parseInt(areaHasta);


        return precio >= precioDesde && precio <= preciohasta && area >= areaDesdeint && area <= areaHastaint && baniosInmueble==banios;

    }

    public static BusquedaCorrecta delInmueble(int precioDesde, int preciohasta, int banios, String areaDesde, String areaHasta){
        return new BusquedaCorrecta(precioDesde,preciohasta,banios,areaDesde,areaHasta);
    }
}
