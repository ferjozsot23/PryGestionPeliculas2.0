package gestorPelicula;

import crud.AdapterCopia;
import crud.AdapterPelicula;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorPelicula {
    private Pelicula pelicula = new Pelicula();
    private AdapterPelicula adaptador = new AdapterPelicula();
    private AdapterCopia adaptadorCopia = new AdapterCopia();

    //Obtener pelicula ya existente en base de datos
    public void setPelicula(String idPelicula){
        pelicula = new Pelicula(adaptador.getPelicula(idPelicula));
    }

    public ArrayList<String> extraerDatosPelicula(){
        return pelicula.getInformacion();
    }

    public void eliminarPelicula(String idPelicula){
        adaptador.eliminarPelicula(idPelicula);
    }
    //Crear pelicula y enviar a la base da datos
    public void agregarPelicula(String titulo, String director, float calificacion, int duracion, double tarifa,String genero, String elenco, String idioma){
        this.pelicula = new Pelicula(titulo, director, calificacion, duracion, tarifa, genero, elenco, idioma);
        adaptador.insertPelicula(this.pelicula);
        this.pelicula.setIdPelicula(adaptador.getPeliculaPorTitulo(titulo).get(0));
    }

    public void actualizarPelicula(String titulo, String director, float calificacion, int duracion, double tarifa,String genero, String elenco, String idioma){
        pelicula.setInformacion(titulo, director, calificacion, duracion, tarifa, genero, elenco, idioma);
        adaptador.actualizarPelicula(this.pelicula);
    }

    public ArrayList getPelicula(String idPelicula){
        return adaptador.getPelicula(idPelicula);
    }

    public HashMap<String,ArrayList<String>> getPeliculas(){
        return adaptador.getPeliculas();
    }

    public HashMap<String,ArrayList<String>> getCopias(){
        return adaptadorCopia.getCopias();
    }

    public void insertarCopias(int numeroCopias, String idPelicula){
        adaptadorCopia.insertarCopias(numeroCopias, idPelicula);
    }

    public void eliminarCopia(String idCopia){
        adaptadorCopia.eliminarCopia(idCopia);
    }
}
