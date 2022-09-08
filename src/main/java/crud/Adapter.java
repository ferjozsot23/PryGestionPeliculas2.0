package crud;

import gestorPelicula.Pelicula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adapter {
    private EnvioRecepcion crud = new EnvioRecepcion();
    private HashMap<String,ArrayList<String>> peliculas;

    public HashMap getPeliculas(){
        ArrayList arrayPeliculas = null;
        try {
            arrayPeliculas = crud.getDatos("http://unisatelite.com/Movies/leerPelicula.php");
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
        this.peliculas = (HashMap) mapPeliculas;
        return (HashMap) mapPeliculas;
    }

    public ArrayList getPelicula(String idPelicula){
        //HashMap mapPeliculas = getPeliculas();
        return (ArrayList) this.peliculas.get(idPelicula);
    }

    public ArrayList<String> getPeliculaPorTitulo(String titulo){
        final ArrayList<String>[] resultadoBusqueda = new ArrayList[]{new ArrayList<>()};
        this.peliculas.forEach((key,value)->{
            if(value.get(1).equals(titulo)) {
                resultadoBusqueda[0] = this.peliculas.get(key);
            }
        });
        return resultadoBusqueda[0];
    }

    public void insertPelicula(Pelicula pelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("titulo",pelicula.getTitulo());
        datosPelicula.put("director", pelicula.getDirector());
        datosPelicula.put("calificacion",Float.toString(pelicula.getCalificacion()));
        datosPelicula.put("duracion", Integer.toString(pelicula.getDuracion()));
        datosPelicula.put("genero",pelicula.getGenero());
        datosPelicula.put("elenco", pelicula.getElenco());
        datosPelicula.put("idioma",pelicula.getIdioma());
        datosPelicula.put("tarifa",Double.toString(pelicula.getTarifa()));
        crud.insertarDatos("http://unisatelite.com/Movies/insertarPelicula.php",datosPelicula);
        this.peliculas = getPeliculas();
    }

    public void eliminarPelicula(String idPelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("id_pelicula",idPelicula);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarPelicula.php",datosPelicula);
        this.peliculas = getPeliculas();
    }

    public void actualizarPelicula(Pelicula pelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("id_pelicula",pelicula.getIdPelicula());
        datosPelicula.put("titulo",pelicula.getTitulo());
        datosPelicula.put("director", pelicula.getDirector());
        datosPelicula.put("calificacion",Float.toString(pelicula.getCalificacion()));
        datosPelicula.put("duracion", Integer.toString(pelicula.getDuracion()));
        datosPelicula.put("genero",pelicula.getGenero());
        datosPelicula.put("elenco", pelicula.getElenco());
        datosPelicula.put("idioma",pelicula.getIdioma());
        datosPelicula.put("tarifa",Double.toString(pelicula.getTarifa()));
        crud.insertarDatos("http://unisatelite.com/Movies/actualizarPelicula.php",datosPelicula);
        this.peliculas = getPeliculas();
    }

}
