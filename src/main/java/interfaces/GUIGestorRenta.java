package interfaces;

import gestorPago.GestorRenta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorRenta extends JDialog {
    private JPanel contentPane;
    private JButton BUSCARButton;
    private JButton AÑADIRButton;
    private JTextField textField1;
    private JComboBox cbIdCopia;
    private JTextField tfIdCliente;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton GUARDARButton;

    public GUIGestorRenta() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        System.exit(0);

        GestorRenta gestorRenta = new GestorRenta();
        AÑADIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GUIGestorCliente cliente = new GUIGestorCliente();
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //el id de recibo
                gestorRenta.crearRenta(tfIdCliente.getText(),cbIdCopia.getSelectedIndex(),1);
            }
        });
    }

}
