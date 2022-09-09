package gestorPelicula;




public class TestConection {
    public static void main (String [] args) {
        GestorPelicula gestorPelicula = new GestorPelicula();
        gestorPelicula.agregarPelicula("Pelicula Chevere", "Bralan", 2.0f, 100, 3, "Comedia", "Marcela Montalvo", "Chino");
        System.out.println(gestorPelicula.extraerDatosPelicula());
        System.out.println(gestorPelicula.getPeliculas().toString());
        //gestorPelicula.setPelicula("1");
        //System.out.println(gestorPelicula.extraerDatosPelicula().toString());
        //gestorPelicula.eliminarPelicula("11");

    }
}
