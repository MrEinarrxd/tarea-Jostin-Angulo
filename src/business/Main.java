/*Jostin Angulo Gonzalez
 Universidad Nacional De Costa Rica
 Estructuras de Datos*/
package business;

import javax.swing.SwingUtilities;
import business.GuiControllers.GuiController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuiController().start());
    }
}