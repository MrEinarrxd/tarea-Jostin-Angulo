package business.GuiControllers;

import javax.swing.JOptionPane;

import business.UsersController;
import domain.lists.Utils;

public class ListController {
    private UsersController userController;

    public ListController(UsersController userController) {
        this.userController = userController;
    }

    public void showMenu() {
        String input = JOptionPane.showInputDialog("Seleccione una opción:\n1. Listar Clientes\n2. Listar Asistentes\n3. Listar Veterinarios");
        switch (input) {
            case "1":
                JOptionPane.showMessageDialog(null, userController.listClients(Utils.UserList));
                break;
            case "2":
                JOptionPane.showMessageDialog(null, userController.listAssistants(Utils.UserList));
                break;
            case "3":
                JOptionPane.showMessageDialog(null, userController.listVets(Utils.UserList));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}