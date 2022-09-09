package gestorPelicula;

import java.util.ArrayList;

public class Copia {

    private String idCopia;
    private boolean disponible;
    private Pelicula pelicula;

    public Copia(ArrayList<String> infoCopia){
        this.idCopia = infoCopia.get(0);
        this.disponible = Boolean.parseBoolean(infoCopia.get(1));
    }
    public String getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(String idCopia) {
        this.idCopia = idCopia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Recibo getPelicula() {
        return pelicula;
    }

    public void setPelicula(Recibo pelicula) {
        this.pelicula = pelicula;
    }
}
