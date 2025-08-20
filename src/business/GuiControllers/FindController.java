package business.GuiControllers;

import javax.swing.JOptionPane;
import business.UsersController;
import domain.lists.List;
import domain.lists.Utils;

public class FindController {
    private UsersController usersController;
    private List userList;

    public FindController(UsersController usersController) {
        this.usersController = usersController;
        this.userList = Utils.UserList;
    }

    public void chooseMenuOption() {
        String input = JOptionPane.showInputDialog("Seleccione una opción:\n1. Buscar Cliente\n2. Buscar Veterinario\n3. Buscar Asistente\n4. Buscar por Día");
        switch (input) {
            case "1":
                String clientId = JOptionPane.showInputDialog("Ingrese el ID del Cliente:");
                JOptionPane.showMessageDialog(null, usersController.findClient(Integer.parseInt(clientId), userList));
                break;
            case "2":
                String vetId = JOptionPane.showInputDialog("Ingrese el ID del Veterinario:");
                JOptionPane.showMessageDialog(null, usersController.findVet(Integer.parseInt(vetId), userList));
                break;
            case "3":
                String asistId = JOptionPane.showInputDialog("Ingrese el ID del Asistente:");
                JOptionPane.showMessageDialog(null, usersController.findAssistant(Integer.parseInt(asistId), userList));
                break;
            case "4":
                String dateId = JOptionPane.showInputDialog("Ingrese el ID de la Fecha:");
                JOptionPane.showMessageDialog(null, (usersController.filterUsersByDay(Integer.parseInt(dateId), userList)));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}
