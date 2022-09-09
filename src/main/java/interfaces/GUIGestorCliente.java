package interfaces;

import gestorCliente.GestorCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorCliente extends JDialog {
    private JPanel contentPane;
    private JButton GUARDARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton buttonOK;
    private JButton ACTUALIZARButton;
    private JButton ELIMINARButton;
    private JButton BUSCARButton;
    GestorCliente gestor = new GestorCliente();
    public GUIGestorCliente() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);

        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gestor.agregarCliente(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText());
                System.out.println("Se imprimio");
            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula=textField1.getText();
                String nombre=textField2.getText();
                String apellido=textField3.getText();
                String direccion=textField4.getText();
                String telefono=textField5.getText();
                gestor.actualizarCliente(cedula,nombre,apellido,direccion,telefono);
            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hola
                gestor.eliminarCliente(textField1.getText());
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula=textField1.getText();
                gestor.setCliente(cedula);
                textField3.setText(gestor.cliente.getNombre());
                textField4.setText(gestor.cliente.getApellido());
                textField5.setText(gestor.cliente.getDireccion());
                textField2.setText(gestor.cliente.getTelefono());

            }
        });

    }
    public static void main(String[] args) {
        GUIGestorCliente dialog = new GUIGestorCliente();
        //dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}
