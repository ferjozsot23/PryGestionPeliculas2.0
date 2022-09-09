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
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private AdapterRenta adaptadorRenta = new AdapterRenta();

    //Creación de renta y guardado en la base de datos
    /*public void agregarRenta(){
        this.rentas.add(new Renta(new java.util.Date()));
        adaptadorRenta.insertarRenta(new Renta(id, new java.util.Date()));
    }*/

    public void agregarRenta(Date fechaInicio, String id_Cliente, int id_Copia){
        adaptadorRenta.insertarRenta(new Renta(fechaInicio, id_Cliente,id_Copia));
        renta = new Renta(fechaInicio, id_Cliente,id_Copia);
    }

    public void obtenerInformacionRenta(int idRenta){
        ArrayList<String> rentaInfo = adaptadorRenta.getRenta(String.valueOf(idRenta));
    }

    public void finalizarRenta(int idRenta, Date fechaEntrega){
        ArrayList<String> rentas = adaptadorRenta.getRenta(String.valueOf(idRenta));
        adaptadorRenta.actualizarRenta(new Renta());
    }

    public void emitirRecibo(){
        this.recibo = new Recibo(adaptadorRenta);  //datos del cliente

    }

    public void emitirMulta(){
        this.multa = new Recibo(this.getDias_extendidos());
    }

    public void calcularDiasExcedidos(Date fechaEntrega){
        int dias_extendidos= (int) ChronoUnit.DAYS.between((Temporal) getFecha_entrega(), (Temporal) fechaEntrega);

    }

}
