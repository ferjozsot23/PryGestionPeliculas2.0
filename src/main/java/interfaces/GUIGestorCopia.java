package interfaces;

import gestorPelicula.GestorPelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GUIGestorCopia extends JDialog {
    private JPanel contentPane;
    private JComboBox cBPelicula;
    private JButton AGREGARButton;
    private JButton ELIMINARButton;
    private JTextField tFCantidadCopias;
    private JComboBox cBCopia;
    GestorPelicula gestorPelicula = new GestorPelicula();

    public GUIGestorCopia() {
        setContentPane(contentPane);
        setModal(true);
        this.setVisible(true);
        dispose();
        cargarPeliculas();
        cargarCopias();


        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(cBPelicula.getSelectedItem());
                HashMap<String, ArrayList<String>> peliculas = gestorPelicula.getPeliculas();
                peliculas.forEach((key,value)->{
                    cBPelicula.addItem(value.get(6));
                    if(value.get(6).equals((String) cBPelicula.getSelectedItem())){
                        gestorPelicula.insertarCopias(Integer.parseInt(tFCantidadCopias.getText()), key);
                    }
                });
                cargarCopias();
            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String idCopia = (String) cBCopia.getSelectedItem();
                String[] parts = idCopia.split("-");
                idCopia = Arrays.asList(parts).get(0);

                gestorPelicula.eliminarCopia(idCopia);
                cargarCopias();
            }
        });
    }

    private void cargarPeliculas(){
        HashMap<String, ArrayList<String>> peliculas = gestorPelicula.getPeliculas();
        cBPelicula.removeAllItems();
        peliculas.forEach((key,value)->{
            cBPelicula.addItem(value.get(6));
        });
    }

    private void cargarCopias(){
        HashMap<String, ArrayList<String>> copias = gestorPelicula.getCopias();
        cBCopia.removeAllItems();
        copias.forEach((key,value)->{
            cBCopia.addItem(key + "-" +  gestorPelicula.getPelicula(value.get(0)).get(6));
        });
    }
}
