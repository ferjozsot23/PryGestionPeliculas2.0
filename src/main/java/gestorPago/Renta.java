package gestorPago;

import gestorCliente.Cliente;
import gestorPelicula.Copia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Renta {
    private Recibo recibo;
    private int id_renta;
    private boolean vigencia;
    private int id_Copia;
    private int id_Cliente;
    private Date fecha_inicio;
    private Date fecha_entrega;
    private final int diasMaximos = 7;
    private int dias_extendidos;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    //constructor
    public Renta(int id_renta, Date fecha_inicio){
        this.id_renta = id_renta;
        this.fecha_inicio = fecha_inicio; //fecha del inicio de la renta
        this.vigencia = true;
        this.fecha_entrega = calcularFechaMaxima(this.fecha_inicio,diasMaximos);
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

    public Recibo getRecibo() {
        return recibo;
    }

    public void asociarRecibo(Recibo r) {
        this.recibo = r;
    }

    public int getId_Copia() {
        return id_Copia;
    }

    public void setId_Copia(int id_Copia) {
        this.id_Copia = id_Copia;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    // función para agregar la factura por la renta de las películas
    public void emitirFactura(){
       // this.factura = new Recibo(this.copiasRentadas);

    }

}

