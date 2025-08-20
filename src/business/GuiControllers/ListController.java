package business.GuiControllers;

import presentation.ListGui;
import business.UsersController;
import domain.lists.Utils;

public class ListController {
    private UsersController userController;

    public ListController(UsersController userController) {
        this.userController = userController;
    }

    public void showMenu() {
        String input = javax.swing.JOptionPane.showInputDialog(
            "Seleccione una opción:\n1. Listar Clientes\n2. Listar Asistentes\n3. Listar Veterinarios"
        );
        String result = "";
        switch (input) {
            case "1":
                result = userController.listClients(Utils.UserList);
                break;
            case "2":
                result = userController.listAssistants(Utils.UserList);
                break;
            case "3":
                result = userController.listVets(Utils.UserList);
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(null, "Opción no válida");
                return;
        }
        if (result == null || result.trim().isEmpty()) {
            result = "No hay usuarios para mostrar.";
        }
        new ListGui(result).setVisible(true);
    }
}