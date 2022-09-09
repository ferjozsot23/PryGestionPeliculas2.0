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
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterRenta adaptadorRenta = new AdapterRenta();
    private AdapterRecibo adapterRecibo = new AdapterRecibo();

    public void agregarRenta(){
        adaptadorRenta.insertarRenta(renta);
    }

    public void actualizarFechaFinalizacion(ArrayList<String> informacionRenta) throws ParseException {
        renta = new Renta(informacionRenta);
        adaptadorRenta.actualizarRenta(renta);
    }

    public void crearRenta(String id_Cliente, int id_Copia, int id_recibo){
        renta = new Renta(new java.util.Date(), id_Cliente,id_Copia,id_recibo);
        adaptadorRenta.insertarRenta(renta);
    }

    public void finalizarRenta(Date fechaFin){
        renta.setFecha_entrega(fechaFin);
        establecerDiasExtendidos(renta.getFecha_Inicio(),fechaFin);
    }

    public void obtenerInformacionRenta(int idRenta){
        this.rentainfo = adaptadorRenta.getRenta(String.valueOf(idRenta));
    }

    public void finalizarRenta(int idRenta, Date fechaEntrega){
        ArrayList<String> rentas = adaptadorRenta.getRenta(String.valueOf(idRenta));

    }

    public void emitirRecibo(){
        recibo = new Recibo();  //datos del cliente
        adapterRecibo.emitirRecibo(new Recibo());
    }



    public HashMap<String,ArrayList> obtenerRecibos(){
        return adapterRecibo.getRecibos();
    }

    public HashMap<String,ArrayList> obtenerRentas(){
        return adaptadorRenta.getRentas();
    }




    public void establecerDiasExtendidos(Date fechaEntrega, Date fechaInicio){
        renta.setDias_extendidos(fechaEntrega.getDay() - fechaInicio.getDay());
    }

}
