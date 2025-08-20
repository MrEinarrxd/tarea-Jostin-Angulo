package business;

import javax.swing.JOptionPane;

import domain.lists.List;
import domain.lists.Utils;

public class ListController {
    private UsersController userController;
    private List userList;

    public ListController(UsersController userController) {
        this.userController = userController;
        this.userList = Utils.UserList;
    }

    public void showMenu() {
        String input = JOptionPane.showInputDialog("Seleccione una opción:\n1. Listar Clientes\n2. Listar Asistentes\n3. Listar Veterinarios");
        switch (input) {
            case "1":
                JOptionPane.showMessageDialog(null, userController.listClients(userList));
                break;
            case "2":
                JOptionPane.showMessageDialog(null, userController.listAssistants(userList));
                break;
            case "3":
                JOptionPane.showMessageDialog(null, userController.listVets(userList));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }
}
