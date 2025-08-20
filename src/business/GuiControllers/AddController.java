package business.GuiControllers;

import presentation.AddGui;
import business.UsersController;
import domain.lists.Utils;
import domain.users.UserAssist;
import domain.users.UserClient;
import domain.users.UserVet;

public class AddController {
    private AddGui view;
    private UsersController usersController;

    public AddController(UsersController usersController) {
        this.view = new AddGui();
        this.usersController = usersController;

    }

    public void showMenu() {
        int option = view.chooseMenuOption();
        switch (option) {
            case 1:
                usersController.addUser(createUser(), Utils.UserList);
               System.out.println("Cliente agregado exitosamente.");
                break;
            case 2:
                usersController.addUser(createVet(), Utils.UserList);
               System.out.println("Veterinario agregado exitosamente.");
                break;
            case 3:
                usersController.addUser(createAsist(), Utils.UserList);
               System.out.println("Asistente agregado exitosamente.");
                break;
            default:
                // Opción inválida o cancelar
                break;
        }
    }
    public UserClient createUser() {
        int id = Integer.parseInt(view.getText("Ingrese el id del usuario:"));
        String name = view.getText("Ingrese el nombre del usuario:");
        String mail = view.getText("Ingrese el mail del usuario:");
        int phone = Integer.parseInt(view.getText("Ingrese el número de teléfono del usuario:"));
        String adress = view.getText("Ingrese la dirección del usuario:");
        Boolean vip = view.getText("¿Es VIP? (1/0)").equals("1");

        return new UserClient(id, name, mail, phone, adress, vip);
    }

    public UserVet createVet() {
        int id = Integer.parseInt(view.getText("Ingrese el id del veterinario:"));
        String name = view.getText("Ingrese el nombre del veterinario:");
        String mail = view.getText("Ingrese el mail del veterinario:");
        int phone = Integer.parseInt(view.getText("Ingrese el número de teléfono del veterinario:"));
        int licenseNumb = Integer.parseInt(view.getText("Ingrese el número de licencia:"));
        String speciality = view.getText("Ingrese la especialidad del veterinario:");
        double salary = Double.parseDouble(view.getText("Ingrese el salario del veterinario:"));
        Boolean activity = view.getText("¿Está activo? (1/0)").equals("1");
        Boolean[] schedule = new Boolean[7];
        for (int i = 0; i < 7; i++) {
            schedule[i] = view.getText("¿Trabaja el día " + (i + 1) + "? (1/0)").equals("1");
        }

        return new UserVet(id, name, mail, phone, licenseNumb, speciality, salary, activity, schedule);
    }

    public UserAssist createAsist() {
        int id = Integer.parseInt(view.getText("Ingrese el id del asistente:"));
        String name = view.getText("Ingrese el nombre del asistente:");
        String mail = view.getText("Ingrese el mail del asistente:");
        int phone = Integer.parseInt(view.getText("Ingrese el número de teléfono del asistente:"));
        int activeYears = Integer.parseInt(view.getText("Ingrese los años activos del asistente:"));
        Boolean active = view.getText("¿Está activo? (1/0)").equals("1");
        Boolean[] schedule = new Boolean[7];
        for (int i = 0; i < 7; i++) {
            schedule[i] = view.getText("¿Trabaja el día " + (i + 1) + "? (1/0)").equals("1");
        }

        return new UserAssist(id, name, mail, phone, activeYears, active, schedule);
    }
}