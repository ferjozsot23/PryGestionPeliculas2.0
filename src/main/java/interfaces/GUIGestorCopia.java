package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGestorCopia extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JButton AGREGARButton;
    private JButton ELIMINARButton;
    private JTextField textField1;
    private JComboBox comboBox2;

    public GUIGestorCopia() {
        setContentPane(contentPane);
        setModal(true);
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        ELIMINARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        GUIGestorCopia dialog = new GUIGestorCopia();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
