package gestorPelicula;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

import crud.EnvioRecepcion;
import org.json.JSONException;
import org.json.JSONObject;

public class TestConection {
    public static void main (String [] args) throws IOException {
        //JSONObject json = readJsonFromUrl("http://unisatelite.com/Movies/registroPelicula.php");
        //System.out.println(json.getJSONArray("data").get(0));

        //JSONObject json2 = (JSONObject) json.getJSONArray("data").get(0);
        //System.out.println(json2.get("id_pelicula"));

        EnvioRecepcion cr = new EnvioRecepcion();
        ArrayList<Map> datos = cr.getDatos("http://unisatelite.com/Movies/getPelicula.php");
        Map mapa = datos.get(0);
        System.out.println(mapa.get("id_pelicula"));

        ArrayList<String> datosPelicula = new ArrayList<>();
        datosPelicula.add((String) mapa.get("id_pelicula"));
        datosPelicula.add((String) mapa.get("titulo").toString());
        datosPelicula.add((String) mapa.get("director").toString());
        datosPelicula.add((String) mapa.get("calificacion").toString());
        datosPelicula.add((String) mapa.get("duracion").toString());
        datosPelicula.add((String) mapa.get("genero").toString());
        datosPelicula.add((String) mapa.get("elenco").toString());
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
