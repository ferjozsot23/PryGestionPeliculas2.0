package gestorPelicula;

import java.util.ArrayList;

public class Pelicula {
    private String titulo, director, idPelicula,genero, elenco, idioma;
    private float calificacion;
    private int duracion;
    private double tarifa;

    public Pelicula(){}
    public Pelicula(String titulo, String director, float calificacion, int duracion, double tarifa, String genero, String elenco, String idioma) {
        this.titulo = titulo;
        this.director = director;
        this.idPelicula = null;
        this.calificacion = calificacion;
        this.duracion = duracion;
        this.tarifa = tarifa;
        this.genero = genero;
        this.elenco = elenco;
        this.idioma = idioma;
    }

    public Pelicula(ArrayList<String> datosPelicula){
        this.idPelicula = datosPelicula.get(0);
        this.titulo = datosPelicula.get(6);
        this.director = datosPelicula.get(3);
        this.calificacion = Float.parseFloat(datosPelicula.get(2));
        this.duracion = Integer.parseInt(datosPelicula.get(7));
        this.genero = datosPelicula.get(5);
        this.elenco = datosPelicula.get(4);
        this.idioma = datosPelicula.get(8);
        this.tarifa = Double.parseDouble(datosPelicula.get(1));
    }

    public ArrayList<String> getInformacion() {
        ArrayList<String> informacion = new ArrayList<>();
        informacion.add(this.idPelicula);
        informacion.add(this.titulo);
        informacion.add(this.director);
        informacion.add(Float.toString(this.calificacion));
        informacion.add(Integer.toString(this.duracion));
        informacion.add(this.genero);
        informacion.add(this.elenco);
        informacion.add(this.idioma);
        informacion.add(Double.toString(this.tarifa));
        return informacion;
    }

    public void setInformacion(String titulo, String director, float calificacion, int duracion, double tarifa,String genero, String elenco, String idioma) {
        this.titulo = titulo;
        this. director = director;
        this.calificacion = calificacion;
        this.duracion = duracion;
        this.tarifa = tarifa;
        this.genero = genero;
        this.elenco = elenco;
        this.idioma = idioma;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getDirector() {
        return director;
    }


    public float getCalificacion() {
        return calificacion;
    }


    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public String getElenco() {
        return elenco;
    }

    public String getIdioma() {
        return idioma;
    }

    public double getTarifa() {
        return tarifa;
    }
}
