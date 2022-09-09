package gestorPelicula;




public class TestConection {
    public static void main (String [] args) {
        GestorPelicula gestorPelicula = new GestorPelicula();
        //gestorPelicula.agregarPelicula("Interestelar 3", "Matucho", 3.7f, 120, 7.50, "Accion", "Mateo Diaz", "Latin");
        gestorPelicula.setPelicula("3");
        System.out.println(gestorPelicula.extraerDatosPelicula().toString());

    }
}
