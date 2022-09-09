package interfaces;

import gestorCliente.GestorCliente;
import gestorPago.GestorRenta;
import gestorPelicula.GestorPelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class GUIGestorRenta extends JDialog {
    private JPanel contentPane;
    private JButton BUSCARButton;
    private JButton AÑADIRButton;
    private JTextField tfNumeroRenta;
    private JComboBox cBCopia;
    private JTextField tfIdCliente;
    private JTextField tFNombreCliente;
    private JTextField tFApellidoCliente;
    private JTextField tFFechaInicio;
    private JButton GUARDARButton;
    GestorPelicula gestorPelicula = new GestorPelicula();

    public GUIGestorRenta() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        //this.pack();
        //this.setVisible(true);
        //System.exit(0);

        GestorRenta gestorRenta = new GestorRenta();
        GestorCliente gestorCliente = new GestorCliente();

        cargarCopias();
        AÑADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIGestorCliente cliente = new GUIGestorCliente();
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                String fechaActual = formatter.format(date);
                HashMap<String, ArrayList<String>> clientes = gestorCliente.getClientes();
                clientes.forEach((key,value)->{
                    if(value.get(0).equals(tfIdCliente.getText())){
                        tFNombreCliente.setText(value.get(4));
                        tFApellidoCliente.setText(value.get(1));
                        tFFechaInicio.setText(fechaActual);
                    }
                });
            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //el id de recibo debe ser el mismo que el id de la renta
                String idCopia = (String) cBCopia.getSelectedItem();
                String[] parts = idCopia.split("-");
                idCopia = Arrays.asList(parts).get(0);
                gestorRenta.crearRenta(tfIdCliente.getText(), Integer.parseInt(idCopia), Integer.parseInt(tfNumeroRenta.getText()));
            }
        });

    }

    private void cargarCopias(){
        HashMap<String, ArrayList<String>> copias = gestorPelicula.getCopias();
        cBCopia.removeAllItems();
        copias.forEach((key,value)->{
            cBCopia.addItem(key + "-" +  gestorPelicula.getPelicula(value.get(0)).get(6));
        });
    }
    public static void main(String[] args) {
        GUIGestorRenta dialog = new GUIGestorRenta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
