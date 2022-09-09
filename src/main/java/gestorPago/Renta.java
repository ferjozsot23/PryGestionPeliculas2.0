package gestorPago;

import gestorCliente.Cliente;
import gestorPelicula.Copia;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Renta {
    private int id_renta;
    private int id_Copia;
    private int id_Recibo;
    private String id_Cliente;
    private Date fecha_inicio;
    private Date fecha_entrega;
    private final int diasMaximos = 7;
    private int dias_extendidos;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    //constructor
    public Renta(Date fecha_inicio, String id_Cliente, int id_Copia,int id_Recibo){
        //this.id_renta = id_renta;
        this.fecha_inicio = fecha_inicio; //fecha del inicio de la renta
        this.fecha_entrega = null;
        this.id_Copia = id_Copia;
        this.id_Cliente = id_Cliente;
        this.id_Recibo = id_Recibo;
    }

    public Renta(int id_Copia, String id_Cliente, Date fecha_inicio, Date fecha_entrega, int dias_extendidos) {
        this.id_Copia = id_Copia;
        this.id_Cliente = id_Cliente;
        this.fecha_inicio = fecha_inicio;
        this.fecha_entrega = fecha_entrega;
        this.dias_extendidos = dias_extendidos;
    }

    public int getId_Recibo() {
        return id_Recibo;
    }

    public void setId_Recibo(int id_Recibo) {
        this.id_Recibo = id_Recibo;
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

    public static Date calcularFechaMaxima(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
/*
    public Recibo getRecibo() {
        return recibo;
    }

    public void asociarRecibo(Recibo r) {
        this.recibo = r;
    }
*/
    public int getId_Copia() {
        return id_Copia;
    }

    public void setId_Copia(int id_Copia) {
        this.id_Copia = id_Copia;
    }

    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
/*
    public Copia getCp() {
        return cp;
    }

    public void agregarCopia(Copia cp) {
        this.cp = cp;
    }
*/
    // función para agregar la factura por la renta de las películas





}

