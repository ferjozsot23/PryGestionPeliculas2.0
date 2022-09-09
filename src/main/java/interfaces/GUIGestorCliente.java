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
    private JComboBox comboBox1;
    private JButton ACTUALIZARButton;
    private JButton ELIMINARButton;

    public GUIGestorCliente() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        System.exit(0);
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GestorCliente gestor= new GestorCliente();
                gestor.agregarCliente(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText());
            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
