package crud;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Crud {
    /*public void insertarDatos(String enlace, HashMap<String, String> datos){
        Set keys = datos.keySet();
        String postData = "";
        for(Object key: keys){
            postData += key + "=" + datos.get(key) + "&";
        }
        postData = postData.substring(0, postData.length()-1);

        envioDatos(enlace, postData);
    }*/

    public void insertarDatos(String enlace, HashMap<String, String> datos){
        try {

            Set keys = datos.keySet();
            String postData = "";
            for(Object key: keys){
                postData += key + "=" + datos.get(key) + "&";
            }
            postData = postData.substring(0, postData.length()-1);

            URL url = new URL(enlace);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
            conn.setUseCaches(false);

            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList getDatos(String enlace) throws IOException {
        JSONArray json = readJsonFromUrl(enlace).getJSONArray("data");
        ArrayList<Map> datos = new ArrayList<>();
        for(int i=0; i<json.length();i++){
            Map map = json.getJSONObject(i).toMap();
            datos.add(map);
        }
        return datos;
    }

    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
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
