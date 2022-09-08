package gestorPelicula;

import java.util.ArrayList;

public class Pelicula {
    private String titulo, director;
    private float calificacion;
    private int duracion;
    private ArrayList<String> genero, elenco, idioma;

    public Pelicula() {

    }

    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }

    public ArrayList<String> getInformacion() {
        return genero;
    }

    public void setInformacion(String genero, String elenco, String idioma) {
        this.genero.add(genero);
        this.elenco.add(elenco);
        this.idioma.add(idioma);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public ArrayList<String> getElenco() {
        return elenco;
    }

    public ArrayList<String> getIdioma() {
        return idioma;
    }
}
