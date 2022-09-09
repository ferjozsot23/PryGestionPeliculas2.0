package gestorPago;

import gestorCliente.Cliente;
import gestorPelicula.Copia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Renta {
    private Recibo r;
    private int id_renta;
    private Cliente c;
    private boolean vigencia;
    private Copia cp;
    private String fecha_inicio;
    private String fecha_entrega;
    private long diasExcedidos;
    private final int diasMaximos = 7;
    private int dias_extendidos;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    //constructor
    public Renta(int id_renta, String fecha_inicio){
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

    public String getFecha_entrega() {
        return (String) fecha_entrega;
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

    public void asociarCliente(Cliente c){
        this.c = c;
    }

    public void agregarCopia(Copia cp){
        this.cp = cp;
    }

    public Cliente getC() {
        return c;
    }

    public Copia getCp() {
        return cp;
    }

    public Recibo getRecibo() {
        return r;
    }

    public void asociarRecibo(Recibo r) {
        this.r = r;
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

