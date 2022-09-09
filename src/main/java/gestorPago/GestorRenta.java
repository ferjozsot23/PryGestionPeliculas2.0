package gestorPago;

import crud.AdapterRecibo;
import crud.AdapterRenta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class GestorRenta {

    private Renta renta;
    private Recibo recibo;
    private Recibo multa;
    private int dias;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterRenta adaptadorRenta = new AdapterRenta();
    private AdapterRecibo adapterRecibo = new AdapterRecibo();

    public void agregarRenta(){
        adaptadorRenta.insertarRenta(renta);
    }

    public void crearRenta(Date fechaInicio, String id_Cliente, int id_Copia, int id_recibo){
        renta = new Renta(fechaInicio, id_Cliente,id_Copia,id_recibo);
        adaptadorRenta.insertarRenta(renta);
    }

    public void finalizarRenta(Date fechaFin){
        renta.setFecha_entrega(fechaFin);
        establecerDiasExtendidos(renta.getFecha_Inicio(),fechaFin);
    }

    public void obtenerInformacionRenta(int idRenta){
        ArrayList<String> rentaInfo = adaptadorRenta.getRenta(String.valueOf(idRenta));
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
