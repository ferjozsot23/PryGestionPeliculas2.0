package gestorPelicula;

import java.util.ArrayList;

public class GestorPelicula {
    private Pelicula pelicula = null;

    public GestorPelicula(ArrayList<String> infoPelicula){
        this.pelicula = new Pelicula(infoPelicula.get(0),infoPelicula.get(1),infoPelicula.get(2));
    }

    public String buscarPelicula(String titulo){
        return "";
    }

    public ArrayList<String> extraerDatosPelicula(){
        return pelicula.getInformacion();
    }

    public void eliminarPelicula(String idPelicula){

    }

    public void agregarPelicula(){
        this.pelicula = new Pelicula();
    }

    public void actualizarPelicula(String genero, String elenco, String idioma){
        pelicula.setInformacion(genero,elenco,idioma);
    }
}
