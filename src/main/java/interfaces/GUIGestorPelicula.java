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
        setMinimumSize(new Dimension(900, 540));
        setModal(true);
        peliculas = gestorPelicula.getPeliculas();
        System.out.println(peliculas.toString());
        actualizarComboBox();
        //this.pack();
        //this.setVisible(true);
        dispose();
        //System.exit(0);

        /*
        cmbPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                textField1.setText(peliculasCMB.get(selected).get(7).toString());
                tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
            }
        });*/


        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ola");
                gestorPelicula.agregarPelicula(tFTitulo.getText(), tFDirector.getText(), Float.parseFloat(tFCalificacion.getText()), Integer.parseInt(textField1.getText()),
                        Double.parseDouble(tFTarifa.getText()), tFGenero.getText(), tFElenco.getText(), tFIdioma.getText());
            actualizarComboBox();
            }

        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                gestorPelicula.eliminarPelicula((String) peliculasCMB.get(selected).get(0));
                actualizarComboBox();
            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                System.out.println("aaa");
                gestorPelicula.setPelicula((String) peliculasCMB.get(selected).get(0));
                gestorPelicula.actualizarPelicula(tFTitulo.getText(), tFDirector.getText(), Float.parseFloat(tFCalificacion.getText()), Integer.parseInt(textField1.getText()),
                        Double.parseDouble(tFTarifa.getText()), tFGenero.getText(), tFElenco.getText(), tFIdioma.getText());
                actualizarComboBox();
            }

        });

        MODIFICARCOPIASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIGestorCopia guiCopia = new GUIGestorCopia();
                //guiCopia.pack();

                guiCopia.setVisible(true);
            }
        });
        /*cmbPeliculas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(flag){
                    int selected = cmbPeliculas.getSelectedIndex();
                    tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                    tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                    tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                    textField1.setText(peliculasCMB.get(selected).get(7).toString());
                    tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                    tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                    tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                    tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
                }
            }
        });*/

        cmbPeliculas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selected = cmbPeliculas.getSelectedIndex();
                tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                textField1.setText(peliculasCMB.get(selected).get(7).toString());
                tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
            }
        });
        /*
        cmbPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = cmbPeliculas.getSelectedIndex();
                tFTitulo.setText(peliculasCMB.get(selected).get(6).toString());
                tFDirector.setText(peliculasCMB.get(selected).get(3).toString());
                tFCalificacion.setText(peliculasCMB.get(selected).get(2).toString());
                textField1.setText(peliculasCMB.get(selected).get(7).toString());
                tFGenero.setText(peliculasCMB.get(selected).get(5).toString());
                tFElenco.setText(peliculasCMB.get(selected).get(4).toString());
                tFIdioma.setText(peliculasCMB.get(selected).get(8).toString());
                tFTarifa.setText(peliculasCMB.get(selected).get(1).toString());
            }
        });*/
    }
        public void actualizarComboBox () {
            peliculas = gestorPelicula.getPeliculas();
            cmbPeliculas.removeAllItems();
            peliculasCMB = new ArrayList<>();
            peliculas.forEach((key, value) -> {
                peliculasCMB.add(value);
                //cmbPeliculas.addItem(new ComboItem("hooa","aaaa"));
                cmbPeliculas.addItem(value.get(6));
            });
        }
        /*
        public static void main (String[]args){
            GUIGestorPelicula dialog = new GUIGestorPelicula();
            dialog.pack();
            dialog.setVisible(true);
            System.exit(0);
        }*/


}



/*class ComboItem {
    public String key;
    public String value;

    public ComboItem(String key, String value) {
        this.key = key;
        this.value = value;
    }
}*/



