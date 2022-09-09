package interfaces;

import gestorPago.GestorRenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
    private JTextField textField7;
    private JTextField tfDiasRenta;
    private JTextField tfTotalCancelar;

    public GUIGestorFactura() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        System.exit(0);
        GestorRenta gestorRenta = new GestorRenta();
        tfFecha.setText(gestorRenta.getFecha());

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gestorRenta.emitirRecibo(Integer.parseInt(tfDiasRenta.getText()));

                try {
                    tfDiasRenta.setText(Integer.toString(gestorRenta.obtenerDias(Integer.parseInt(tfNumeroRenta.getText()),tfFecha.getText())));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }


                tfTotalCancelar.setText(Float.toString(gestorRenta.getMonto()));
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
