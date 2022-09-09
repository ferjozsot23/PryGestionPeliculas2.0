package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorFactura extends JDialog {
    private JPanel contentPane;
    private JTextField textField1;
    private JButton GUARDARButton;
    private JButton BUSCARButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;

    public GUIGestorFactura() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        System.exit(0);
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
