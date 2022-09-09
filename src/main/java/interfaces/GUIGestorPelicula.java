package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorPelicula {
    private JButton INGRESEButton;
    private JButton INGRESEButton1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton ACTUALIZARButton;
    private JButton GUARDARButton;
    private JButton AÑADIRPELÍCULAButton;
    private JButton BUSCARButton;

    public GUIGestorPelicula() {
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
