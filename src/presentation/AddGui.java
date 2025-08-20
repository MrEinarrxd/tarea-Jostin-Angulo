package presentation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddGui extends JFrame{

    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                AddGui frame = new AddGui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }

    private static final long serialVersionUID = 1L;

    public AddGui() {
    }

    public int chooseMenuOption() {
        String msg = "Seleccione una opción:\n"
                + "1. Agregar Cliente\n"
                + "2. Agregar Veterinario\n"
                + "3. Agregar Asistente\n"
                + "0. Cancelar";
        String input = JOptionPane.showInputDialog(null, msg, "Menú", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(input);
    }

    public String getText(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

}
