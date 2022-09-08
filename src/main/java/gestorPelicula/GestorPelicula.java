package gestorPelicula;

import crud.Adapter;

import java.util.ArrayList;

public class GestorPelicula {
    private Pelicula pelicula;
    private Adapter adaptador = new Adapter();

    public GestorPelicula(){
        pelicula = null;
    }

    public String buscarPelicula(String titulo){
        return "";
    }

    public ArrayList<String> extraerDatosPelicula(){
        return pelicula.getInformacion();
    }

    public void eliminarPelicula(String idPelicula){

    }

    public void agregarPelicula(String titulo, String director, float calificacion, int duracion, double tarifa, ArrayList<String> genero, ArrayList<String> elenco, ArrayList<String> idioma){
        this.pelicula = new Pelicula(titulo, director, calificacion, duracion, tarifa, genero, elenco, idioma);
        adaptador.insertPelicula(this.pelicula);

    }

    public void actualizarPelicula(String genero, String elenco, String idioma){
        pelicula.setInformacion(genero,elenco,idioma);
    }
}
