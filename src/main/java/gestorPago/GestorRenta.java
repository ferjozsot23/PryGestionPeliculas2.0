package gestorPago;

import crud.AdapterRenta;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;

public class GestorRenta {

    private Renta renta;
    private Recibo recibo;
    private Recibo multa;
    private int dias;
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterRenta adaptadorRenta = new AdapterRenta();

    public void agregarRenta(){
        adaptadorRenta.insertarRenta(renta);

    }

    public void crearRenta(Date fechaInicio, String id_Cliente, int id_Copia){
        renta = new Renta(fechaInicio, id_Cliente,id_Copia);
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
/*
    public void emitirRecibo(){
        this.recibo = new Recibo(adaptadorRenta);  //datos del cliente

    }
*/

    public void establecerDiasExtendidos(Date fechaEntrega, Date fechaInicio){
        renta.setDias_extendidos(fechaEntrega.getDay() - fechaInicio.getDay());
    }

}
