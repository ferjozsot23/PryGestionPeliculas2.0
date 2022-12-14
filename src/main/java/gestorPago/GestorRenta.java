package gestorPago;

import crud.AdapterRecibo;
import crud.AdapterRenta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class GestorRenta {

    private Renta renta;
    private Recibo recibo;
    private Recibo multa;
    private int dias;
    private ArrayList<String> rentainfo = new ArrayList<>();
    private ArrayList<String> reciboinfo = new ArrayList<>();
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterRenta adaptadorRenta = new AdapterRenta();
    private AdapterRecibo adapterRecibo = new AdapterRecibo();

    public void agregarRenta(){
        adaptadorRenta.insertarRenta(renta);
    }


    public void obtenerInformacionRecibo(int idRecibo){
        this.reciboinfo = adapterRecibo.getRecibo(String.valueOf(idRecibo));
    }


    public void actualizarFechaFinalizacion(ArrayList<String> informacionRenta) throws ParseException {
        renta = new Renta(informacionRenta);
        adaptadorRenta.actualizarRenta(renta);
    }
    public void actualizarDescripcion(ArrayList<String> informacionRecibo){
        recibo = new Recibo(informacionRecibo);
        adapterRecibo.actualizarRecibo(recibo);
    }

    public void crearRenta(String id_Cliente, int id_Copia, int id_recibo){
        renta = new Renta(new java.util.Date(), id_Cliente,id_Copia,id_recibo);
        adaptadorRenta.insertarRenta(renta);
    }

    public void finalizarRenta(Date fechaFin){
        renta.setFecha_entrega(fechaFin);
        establecerDiasExtendidos(renta.getFecha_Inicio(),fechaFin);
    }

    public ArrayList<String> obtenerInformacionRenta(int idRenta){
        this.rentainfo = adaptadorRenta.getRenta(String.valueOf(idRenta));
        return this.rentainfo;
    }

    public void finalizarRenta(int idRenta, Date fechaEntrega){
        ArrayList<String> rentas = adaptadorRenta.getRenta(String.valueOf(idRenta));

    }

    public void emitirRecibo(int dias){
        recibo = new Recibo(dias);  //datos del cliente
        adapterRecibo.emitirRecibo(new Recibo(dias));
    }
    public float getMonto(){
        return recibo.getMonto();
    }
    public String getFecha(){
        return date.format(new java.util.Date());
    }

    public void setDetalle(String detalle){
        recibo.setDetalles(detalle);
    }

    public HashMap<String,ArrayList> obtenerRecibos(){
        return adapterRecibo.getRecibos();
    }

    public HashMap<String,ArrayList> obtenerRentas(){
        return adaptadorRenta.getRentas();
    }


    public int obtenerDias(int idRenta, String fechaEntrega) throws ParseException {
        obtenerInformacionRenta(idRenta);
        Date fechainicio = date.parse(rentainfo.get(1));
        return date.parse(fechaEntrega).getDay() - fechainicio.getDay();
    }

    public void establecerDiasExtendidos(Date fechaEntrega, Date fechaInicio){
        renta.setDias_extendidos(fechaEntrega.getDay() - fechaInicio.getDay());
    }

}
