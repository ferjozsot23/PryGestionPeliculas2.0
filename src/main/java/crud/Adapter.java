package crud;

import gestorPelicula.Pelicula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter {
    private Crud crud = new Crud();

    public HashMap getPeliculas(){
        ArrayList arrayPeliculas = null;
        try {
            arrayPeliculas = crud.getDatos("http://unisatelite.com/Movies/getPelicula.php");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map mapPeliculas = new HashMap();
        for(Object pelicula: arrayPeliculas){
            ArrayList<String> datosPelicula = new ArrayList<>();
            ((HashMap<String,String>)pelicula).forEach((key,value)->{
                datosPelicula.add(value);
            });
            mapPeliculas.put(((HashMap<String,String>)pelicula).get("id_pelicula"),datosPelicula);
        }
        return (HashMap) mapPeliculas;
    }

    public ArrayList getPelicula(String idPelicula){
        HashMap mapPeliculas = getPeliculas();
        return (ArrayList) mapPeliculas.get(idPelicula);
    }

    public void insertPelicula(Pelicula pelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("titulo",pelicula.getTitulo());
        datosPelicula.put("director", pelicula.getDirector());
        datosPelicula.put("calificacion",Float.toString(pelicula.getCalificacion()));
        datosPelicula.put("duracion", Integer.toString(pelicula.getDuracion()));
        String generoPelicula = pelicula.getGenero().toString();
        datosPelicula.put("genero",generoPelicula.substring(1,generoPelicula.length()-1));
        String elencoPelicula = pelicula.getElenco().toString();
        datosPelicula.put("elenco",elencoPelicula.substring(1,elencoPelicula.length()-1));
        String idiomaPelicula = pelicula.getIdioma().toString();
        datosPelicula.put("idioma",idiomaPelicula.substring(1,idiomaPelicula.length()-1));
        crud.insertarDatos("http://unisatelite.com/Movies/insertarPelicula.php",datosPelicula);
    }

}
