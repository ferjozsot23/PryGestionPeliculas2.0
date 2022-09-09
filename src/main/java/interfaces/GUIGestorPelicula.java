package interfaces;

import gestorPelicula.GestorPelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorPelicula extends JDialog {
    private JPanel contentPane;
    private JButton buscarButton;
    private JButton ELIMINARButton;
    private JButton ACTUALIZARButton;
    private JButton GUARDARButton;
    private JTextField tFTitulo;
    private JTextField tFDirector;
    private JTextField tFCalificacion;
    private JTextField tFDuracion;
    private JTextField tFGenero;
    private JTextField tFElenco;
    private JTextField tFIdioma;
    private JTextField tFTarifa;
    private JButton MODIFICARCOPIASButton;

    public GUIGestorPelicula() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        this.pack();
        this.setVisible(true);
        System.exit(0);

        GestorPelicula gestorPelicula = new GestorPelicula();

        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                gestorPelicula.actualizarPelicula(tFTitulo.getText(), tFDirector.getText(), Float.parseFloat(tFCalificacion.getText()), Integer.parseInt(tFDuracion.getText()), Double.parseDouble(tFTarifa.getText()), tFGenero.getText(), tFElenco.getText(), tFIdioma.getText());

            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                gestorPelicula.agregarPelicula(tFTitulo.getText(), tFDirector.getText(), Float.parseFloat(tFCalificacion.getText()), Integer.parseInt(tFDuracion.getText()), Double.parseDouble(tFTarifa.getText()), tFGenero.getText(), tFElenco.getText(), tFIdioma.getText());

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        MODIFICARCOPIASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}



