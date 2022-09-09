package gestorPago;

import gestorPelicula.Copia;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;

public class Renta {
    private int id_renta;

    private boolean vigencia;

    private Date fecha_inicio;
    private Date fecha_entrega;
    private long diasExcedidos;
    private final int diasMaximos = 7;
    private int dias_extendidos;

    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

    public ArrayList<Copia> copiasRentadas;
    //constructor
    public Renta(){
        this.fecha_inicio = new java.util.Date(); //fecha del inicio de la renta
        this.vigencia = true;
        this.fecha_entrega = calcularFechaMaxima(this.fecha_inicio,diasMaximos);

        this.copiasRentadas = new ArrayList<>();

    }

    public int getId_renta() {
        return id_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public Date getFecha_Inicio() {
        return fecha_inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_inicio = fecha_Inicio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_Fin) {
        this.fecha_entrega = fecha_Fin;
    }

    public int getDias_extendidos() {
        return dias_extendidos;
    }

    public void setDias_extendidos(int dias_extendidos) {
        this.dias_extendidos = dias_extendidos;
    }


    // añadir una película a la lista de películas a rentar
    public void agregarPelicula(Copia c){
        copiasRentadas.add(c);
    }
    // eliminar una película a la lista de películas a rentar
    public void removerPelicula(Copia c){
        copiasRentadas.remove(c);
    }


    public static Date calcularFechaMaxima(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    // función para agregar la factura por la renta de las películas
    public void emitirFactura(){
       // this.factura = new Recibo(this.copiasRentadas);

    }

    // función para agregar la multa en caso de haber retraso en la fecha de entrega
    public void emitirMulta(){
        //this.multa = new Recibo((int)this.diasExcedidos,this.copiasRentadas.size());

    }

}

