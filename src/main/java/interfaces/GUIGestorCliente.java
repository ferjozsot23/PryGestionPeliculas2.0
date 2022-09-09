package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorCliente {
    private JButton AÑADIRPELÍCULAButton;
    private JButton INGRESEButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton INGRESEButton1;
    private JTextField textField5;
    private JButton GUARDARButton;
    private JButton BUSCARButton;
    private JButton ACTUALIZARButton;

    public GUIGestorCliente() {
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
