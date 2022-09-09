package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JDialog {
    private JPanel contentPane;
    private JButton AÑADIRPELÍCULAButton;
    private JButton REALIZARRENTAButton;
    private JButton GENERARFACTURAButton;

    public MainWindow() {
        setTitle("MeanWindow");
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,400));
        setModal(true);
        AÑADIRPELÍCULAButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                GUIGestorPelicula pelicula = new GUIGestorPelicula();
                dispose();
            }
        });
        REALIZARRENTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                GUIGestorRenta renta = new GUIGestorRenta();
                dispose();
            }
        });
        GENERARFACTURAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                GUIGestorFactura factura = new GUIGestorFactura();
            }
        });
    }
    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
