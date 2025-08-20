package business.GuiControllers;

import presentation.AddGui;
import business.UsersController;
import domain.lists.Utils;
import domain.users.UserAssist;
import domain.users.UserClient;
import domain.users.UserVet;

import javax.swing.*;

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
                        JOptionPane.showMessageDialog(view, "Cliente agregado exitosamente.");
                    }
                    break;
                case 1:
                    UserVet vet = createVetFromFields();
                    if (vet != null) {
                        usersController.addUser(vet, Utils.UserList);
                        JOptionPane.showMessageDialog(view, "Veterinario agregado exitosamente.");
                    }
                    break;
                case 2:
                    UserAssist assist = createAsistFromFields();
                    if (assist != null) {
                        usersController.addUser(assist, Utils.UserList);
                        JOptionPane.showMessageDialog(view, "Asistente agregado exitosamente.");
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
            String adress = JOptionPane.showInputDialog(view, "Ingrese la dirección del cliente:");
            // Preguntar por VIP usando JOptionPane
            Boolean vip = JOptionPane.showConfirmDialog(view, "¿Es cliente VIP?", "VIP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            return new UserClient(id, name, mail, phone, adress, vip);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Datos inválidos: " + ex.getMessage());
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
            int licenseNumb = Integer.parseInt(JOptionPane.showInputDialog(view, "Ingrese el número de licencia:"));
            String speciality = JOptionPane.showInputDialog(view, "Ingrese la especialidad del veterinario:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog(view, "Ingrese el salario del veterinario:"));
            Boolean activity = JOptionPane.showConfirmDialog(view, "¿Está activo?", "Actividad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            Boolean[] schedule = new Boolean[7];
            for (int i = 0; i < 7; i++) {
                schedule[i] = JOptionPane.showConfirmDialog(view, "¿Trabaja el día " + (i + 1) + "?", "Horario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }
            return new UserVet(id, name, mail, phone, licenseNumb, speciality, salary, activity, schedule);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Datos inválidos: " + ex.getMessage());
            return null;
        }
    }

    private UserAssist createAsistFromFields() {
        try {
            int id = Integer.parseInt(view.getTextFieldId().getText());
            String name = view.getTextFieldName().getText();
            String mail = view.getTextFieldMail().getText();
            int phone = Integer.parseInt(view.getTextFieldPhone().getText());
            int activeYears = Integer.parseInt(JOptionPane.showInputDialog(view, "Ingrese los años activos del asistente:"));
            Boolean active = JOptionPane.showConfirmDialog(view, "¿Está activo?", "Actividad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            Boolean[] schedule = new Boolean[7];
            for (int i = 0; i < 7; i++) {
                schedule[i] = JOptionPane.showConfirmDialog(view, "¿Trabaja el día " + (i + 1) + "?", "Horario", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }
            return new UserAssist(id, name, mail, phone, activeYears, active, schedule);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Datos inválidos: " + ex.getMessage());
            return null;
        }
    }
}