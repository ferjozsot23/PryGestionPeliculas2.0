package crud;

import gestorPelicula.Recibo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdapterPelicula {
    private EnvioRecepcion crud = EnvioRecepcion.obtenerInstancia();
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
        //this.peliculas = (HashMap) mapPeliculas;
        return (HashMap) mapPeliculas;
    }

    public ArrayList getPelicula(String idPelicula){
        //HashMap mapPeliculas = getPeliculas()
        if(this.peliculas == null){
            this.peliculas = getPeliculas();
        }
        return (ArrayList) this.peliculas.get(idPelicula);
    }

    public ArrayList<String> getPeliculaPorTitulo(String titulo){
        ArrayList<String> resultadoBusqueda = new ArrayList<>();
        Set keys = this.peliculas.keySet();
        //System.out.println(keys.toString());
        for(Object key: keys){
            //System.out.println(key);
            if(this.peliculas.get(key).get(6).equals(titulo)) {
                //System.out.println("alo");
                resultadoBusqueda = this.peliculas.get(key);
            }
        }
        /*this.peliculas.forEach((key,value)->{
            if(value.get(1).equals(titulo)) {
                resultadoBusqueda.set(this.peliculas.get(key));
            }
        });*/
        return resultadoBusqueda;
    }

    public void insertPelicula(Recibo pelicula){
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
        System.out.println(this.peliculas.toString());
    }

    public void eliminarPelicula(String idPelicula){
        HashMap<String,String> datosPelicula = new HashMap<>();
        datosPelicula.put("id_pelicula",idPelicula);
        crud.insertarDatos("http://unisatelite.com/Movies/borrarPelicula.php",datosPelicula);
        this.peliculas = getPeliculas();
    }

    public void actualizarPelicula(Recibo pelicula){
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
