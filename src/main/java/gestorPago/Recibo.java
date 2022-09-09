package gestorPago;

import gestorCliente.Cliente;
import gestorPelicula.Copia;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public  class Recibo {
    //
    int id_recibo;
    private Date fecha;
    float monto;
    String detalles;
    float multa;
    //cambiar por lista de copias
    //actualziar a id de renta
    Copia contenido;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    //aqui se reciben un listado de copias; cambiar String por copia
    public Recibo() {
        this.id_recibo=id_recibo;
        fecha = new java.util.Date();
        this.monto=calcularSubTotal();
        generarDetalles();
    }

    public void generarDetalles(){//efectivo: dinero fisico entregado por el comprador
        detalles="";
        detalles+="ALQUILER\tFecha: Quito, "+fecha+"\tDescripcion: Alquiler\t"+"Total USD: "+calcularTotal();
    }
    public void generarDetallesMulta(){//efectivo: dinero fisico entregado por el comprador
        detalles="";
        detalles+="Multa\tFecha: Quito, "+fecha+"\tDescripcion: Multa\t"+"Total USD: "+calcularTotal();
    }
    public float calcularTotal() {
        float total=monto+calcularImpuestos();
        total=(float) (Math.round(total*100.0)/100.0);
        return total;
    }

    public float calcularSubTotal() {
        float subTotal= 1.5F;
        subTotal=(float) (Math.round(subTotal*100.0)/100.0);
        return subTotal;
    }

    public float calcularImpuestos() {
        float impuesto=(float) (0.12*monto);
        return  impuesto;
    }


    public String getDetalles(){ return this.detalles; }

    public int getId_recibo() { return id_recibo; }

    public String getFecha() { return date.format(fecha) ; }

    public float getMonto() { return monto; }

    public float getMulta() { return multa; }

    public Copia getContenido() { return contenido; }

    public void setId_recibo(int id_recibo) { this.id_recibo = id_recibo; }

    public void setFecha(Date fecha) { this.fecha = fecha; }

    public void setMonto(float monto) { this.monto = monto; }

    public void setDetalles(String detalles) { this.detalles = detalles; }

    public void setMulta(float multa) { this.multa = multa; }

    public void setContenido(Copia contenido) { this.contenido = contenido; }
}