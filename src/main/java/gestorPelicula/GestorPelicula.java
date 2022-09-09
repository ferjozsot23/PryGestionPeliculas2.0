package gestorPelicula;

import crud.Adapter;

import java.util.ArrayList;

public class GestorPelicula {
    private Pelicula pelicula = new Pelicula();
    private Adapter adaptador = new Adapter();

    public GestorPelicula(){

    }
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
}
