package gestorPelicula;




public class TestConection {
    public static void main (String [] args) {
        GestorPelicula gestorPelicula = new GestorPelicula();
        gestorPelicula.agregarPelicula("Interestelar 4", "Matucho", 3.7f, 120, 7.50, "Accion", "Mateo Diaz", "Latin");
        System.out.println(gestorPelicula.extraerDatosPelicula());
        //gestorPelicula.setPelicula("1");
        //System.out.println(gestorPelicula.extraerDatosPelicula().toString());
        //gestorPelicula.eliminarPelicula("11");

    }
}
