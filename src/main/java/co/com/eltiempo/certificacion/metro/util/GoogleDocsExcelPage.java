package co.com.eltiempo.certificacion.metro.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.PageObject;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleDocsExcelPage extends PageObject {

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
    private static final String APPLICATION_NAME = "Cliente web 1";
    Logger logger = Logger.getLogger(GoogleDocsExcelPage.class.getName());
    final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

    public GoogleDocsExcelPage() throws GeneralSecurityException, IOException {
    }

    private Credential getCredentials() throws IOException {
        LocalServerReceiver receiver = null;
        GoogleAuthorizationCodeFlow flow = null;
        try {
            InputStream accesoApiGoogle = new FileInputStream(obtenerCredencialesJson());
            if (accesoApiGoogle == null) {
                throw new FileNotFoundException("Ruta no encontrada en el directorio: " + obtenerCredencialesJson());
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(accesoApiGoogle));
            // Build flow and trigger user authorization request.
            flow = new GoogleAuthorizationCodeFlow.Builder(
                    httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                    .setDataStoreFactory(new FileDataStoreFactory(new File(String.valueOf(obtenerTokenApiGoogle()))))
                    .setAccessType("offline")
                    .build();
            receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void obtenerDataDrivenExcelOnline(int fila, DataTable dataExcel) {
        Helpers.data.clear();
        List<Map<String, String>> datosFeature = dataExcel.asMaps(String.class, String.class);
        try {
            String spreadsheetId = EnvChooser.chooseEnv("QA");
            String range = rangoDatadriven(datosFeature.get(0).get("Hoja"));
            Sheets service = new Sheets.Builder(httpTransport, JSON_FACTORY, getCredentials())
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            ValueRange response = service.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
            List<List<Object>> values = response.getValues();
            if (values != null || !values.isEmpty()) {
                for (int i = 0; i < values.size(); i++) {
                    if (i > 0 && i == fila) {
                        generaCabeceraExcel(values);
                        /*Leemos los datos del excel online y de la fila correspondiente tomamos los valores del encabezado y fila*/
                        for (int j = 0; j < values.get(fila).size(); j++) {
                            Helpers.data.put(values.get(0).get(j).toString(), values.get(fila).get(j).toString());
                        }
                        break;
                    }
                }
            }
            if (Helpers.data.isEmpty()) {

            }
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }

    }

    private void generaCabeceraExcel(List<List<Object>> valores) {
        int cantidadColumnas = valores.get(0).size();
        for (int i = 0; i < cantidadColumnas; i++) {
            Helpers.data.put(valores.get(0).get(i).toString(), "");
        }
    }

    public String rangoDatadriven(String hoja) {
        String rangoHoja;
        hoja = hoja.trim();
        switch (hoja) {
            default:
                throw new IllegalStateException("Valor inesperado: " + hoja.trim().toLowerCase());
            case "LoginPortafolio":
                rangoHoja = hoja + "!A:F";
                break;
            case "BusquedaPortafolio":
                rangoHoja = hoja + "!A:F";
                break;
        }
        return rangoHoja;
    }

    public File obtenerCredencialesJson() {
        File credenciales = new File("./src/test/resources/credential/credentials.json");
        return credenciales;
    }

    public File obtenerTokenApiGoogle() {
        File tokenApi = new File("./src/test/resources/credential/");
        return tokenApi;
    }
}
