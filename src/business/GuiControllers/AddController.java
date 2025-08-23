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
        setupListeners();
    }
    @SuppressWarnings("unused")
    private void setupListeners() {
        view.getBtnAgregar().addActionListener(e -> {
            int selected = view.getComboBox().getSelectedIndex();
            switch (selected) {
                case 0:
                    UserClient client = createUserFromFields();
                    if (client != null) {
                        usersController.addUser(client, Utils.UserList);
                        view.printMessage(  "Cliente agregado exitosamente.");
                    }
                    break;
                case 1:
                    UserVet vet = createVetFromFields();
                    if (vet != null) {
                        usersController.addUser(vet, Utils.UserList);
                        view.printMessage("Veterinario agregado exitosamente.");
                    }
                    break;
                case 2:
                    UserAssist assist = createAsistFromFields();
                    if (assist != null) {
                        usersController.addUser(assist, Utils.UserList);
                        view.printMessage("Asistente agregado exitosamente.");
                    }
                    break;
                default:
                    break;
            }
        });
    }

    public void showMenu() {
        view.setVisible(true);
    }

    private UserClient createUserFromFields() {
        try {
            int id = Integer.parseInt(view.getTextFieldId().getText());
            String name = view.getTextFieldName().getText();
            String mail = view.getTextFieldMail().getText();
            int phone = Integer.parseInt(view.getTextFieldPhone().getText());
            String adress = view.showInputDialog("Ingrese la dirección del cliente:");
            // Preguntar por VIP usando JOptionPane
            Boolean vip = view.showConfirmDialog("¿El cliente es VIP?", "Cliente VIP").equals("Sí"); 
            return new UserClient(id, name, mail, phone, adress, vip);
        } catch (Exception ex) {
            view.printMessage("Datos inválidos: " + ex.getMessage());
            return null;
        }
    }

    private UserVet createVetFromFields() {
        try {
            int id = Integer.parseInt(view.getTextFieldId().getText());
            String name = view.getTextFieldName().getText();
            String mail = view.getTextFieldMail().getText();
            int phone = Integer.parseInt(view.getTextFieldPhone().getText());
            // For simplicity, you may need to add extra fields for Vet in the GUI
            int licenseNumb = Integer.parseInt(view.showInputDialog("Ingrese el número de licencia del veterinario:"));
            String speciality = view.showInputDialog("Ingrese la especialidad del veterinario:");
            double salary = Double.parseDouble(view.showInputDialog("Ingrese el salario del veterinario:"));
            Boolean activity = view.showConfirmDialog("¿Está activo?", "Actividad").equals("Sí");
            Boolean[] schedule = new Boolean[7];
            for (int i = 0; i < 7; i++) {
                schedule[i] = view.showConfirmDialog("¿Trabaja el día " + (i + 1) + "?", "Horario").equals("Sí");
            }
            return new UserVet(id, name, mail, phone, licenseNumb, speciality, salary, activity, schedule);
        } catch (Exception ex) {
            view.printMessage("Datos inválidos: " + ex.getMessage());
            return null;
        }
    }

    private UserAssist createAsistFromFields() {
        try {
            int id = Integer.parseInt(view.getTextFieldId().getText());
            String name = view.getTextFieldName().getText();
            String mail = view.getTextFieldMail().getText();
            int phone = Integer.parseInt(view.getTextFieldPhone().getText());
            int activeYears = Integer.parseInt(view.showInputDialog("Ingrese los años activos del asistente:"));
            Boolean active = view.showConfirmDialog("¿Está activo?", "Actividad").equals("Sí");
            Boolean[] schedule = new Boolean[7];
            for (int i = 0; i < 7; i++) {
                schedule[i] = view.showConfirmDialog("¿Trabaja el día " + (i + 1) + "?", "Horario").equals("Sí");
            }
            return new UserAssist(id, name, mail, phone, activeYears, active, schedule);
        } catch (Exception ex) {
            view.printMessage("Datos inválidos: " + ex.getMessage());
            return null;
        }
    }
}