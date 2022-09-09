package interfaces;

import gestorPelicula.GestorPelicula;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    private JTextField textField1;
    private JButton MODIFICARCOPIASButton;
    private JComboBox cmbPeliculas;
    GestorPelicula gestorPelicula = new GestorPelicula();
    HashMap<String, ArrayList<String>> peliculas = gestorPelicula.getPeliculas();
    ArrayList<ArrayList> peliculasCMB = new ArrayList<>();



    public GUIGestorPelicula() {
        setContentPane(contentPane);
        setMinimumSize(new Dimension(900,540));
        setModal(true);
        peliculas = gestorPelicula.getPeliculas();
        System.out.println(peliculas.toString());
        actualizarComboBox();
        this.pack();
        this.setVisible(true);

        System.exit(0);


        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            //System.out.println("alo");
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("alo2");
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
        cmbPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                tFDuracion.setText(peliculasCMB.get(selected).get(7).toString());
                tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
            }
        });

        cmbPeliculas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                tFDuracion.setText(peliculasCMB.get(selected).get(7).toString());
                tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ola");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public void actualizarComboBox(){
        //cmbPeliculas.removeAllItems();
        peliculasCMB = new ArrayList<>();
        peliculas.forEach((key,value)->{
            peliculasCMB.add(value);
            //cmbPeliculas.addItem(new ComboItem("hooa","aaaa"));
            cmbPeliculas.addItem(value.get(6));
        });
        //cmbPeliculas.addItem();
    }
    public static void main(String[] args) {
        GUIGestorPelicula dialog = new GUIGestorPelicula();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

/*class ComboItem {
    public String key;
    public String value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
}*/



