package interfaces;

import crud.AdapterCliente;
import gestorCliente.GestorCliente;
import gestorPago.GestorRenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

public class GUIGestorFactura extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton GUARDARButton;
    private JButton BUSCARButton;
    private JTextField tfNumeroRenta;
    private JTextField tfNombreCliente;
    private JTextField tfApellidoCliente;
    private JTextField tfIdCliente;
    private JTextField tfFecha;
    private JTextField tfDetalle;
    private JTextField tfDiasRenta;
    private JTextField tfTotalCancelar;

    public GUIGestorFactura() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        dispose();
        GestorRenta gestorRenta = new GestorRenta();
        GestorCliente gestorCliente = new GestorCliente();
        tfFecha.setText(gestorRenta.getFecha());

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gestorRenta.emitirRecibo(Integer.parseInt(tfDiasRenta.getText()));
                gestorRenta.setDetalle(tfDetalle.getText());
            }
        });
        //accion para calcular valores DiaRenta
        tfFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    tfDiasRenta.setText(Integer.toString(gestorRenta.obtenerDias(Integer.parseInt(tfNumeroRenta.getText()),tfFecha.getText())));
                    tfTotalCancelar.setText(Float.toString(gestorRenta.getMonto()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ArrayList<String> informacion = gestorRenta.obtenerInformacionRenta(Integer.parseInt(tfNumeroRenta.getText()));
                    String idCliente = informacion.get(2);
                    ArrayList<String> informacionCliente = gestorCliente.obtenerInformacionCliente(idCliente);
                    tfNombreCliente.setText(informacionCliente.get(1));
                    tfApellidoCliente.setText(informacionCliente.get(2));
                    tfIdCliente.setText(informacionCliente.get(0));
                }catch(Exception e){
                    tfNumeroRenta.setText("");
                }

            }
        });
    }
}
