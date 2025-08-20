package business.GuiControllers;

import javax.swing.JOptionPane;
import business.UsersController;
import domain.lists.List;
import domain.lists.Utils;
import presentation.FilterGui;

public class FilterController {
    private UsersController usersController;
    private List userList;
    private FilterGui view;

    public FilterController(UsersController usersController) {
        this.usersController = usersController;
        this.userList = Utils.UserList;
        this.view = new FilterGui();
        setupListeners();
    }

    @SuppressWarnings("unused")
    private void setupListeners() {
        view.getBtnFiltrar().addActionListener(e -> {
            int selected = view.getComboBox().getSelectedIndex();
            switch (selected) {
                case 0: // Filtrar por ID
                    try {
                        int id = Integer.parseInt(view.getTextFieldIdFilter().getText());
                        Object result = usersController.findUser(id, userList);
                        JOptionPane.showMessageDialog(view, result != null ? result : "No encontrado");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, "ID inválido");
                    }
                    break;
                case 1: // Filtrar por Día
                    try {
                        int day = Integer.parseInt(view.getTextFieldDayFilter().getText());
                        Object[] users = usersController.filterUsersByDay(day, userList);
                        JOptionPane.showMessageDialog(view, users != null ? java.util.Arrays.toString(users) : "No encontrado");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, "Día inválido");
                    }
                    break;
                case 2: // Filtrar por Fecha (rango)
                    try {
                        String[] fechas = view.getDateFilterFTxTF().getText().split("-");
                        if (fechas.length == 2) {
                            java.time.LocalDate date1 = parseDate(fechas[0].trim());
                            java.time.LocalDate date2 = parseDate(fechas[1].trim());
                            Object[] clients = usersController.filterClientsWithDatesBetween(date1, date2, Utils.DateList);
                            JOptionPane.showMessageDialog(view, clients != null ? java.util.Arrays.toString(clients) : "No encontrado");
                        } else {
                            JOptionPane.showMessageDialog(view, "Formato de fecha incorrecto. Use dd/mm/yy-dd/mm/yy");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, "Fechas inválidas");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(view, "Opción no válida");
            }
        });

        // Habilitar/deshabilitar campos según filtro seleccionado
        view.getBtnSelectFilter().addActionListener(e -> {
            int selected = view.getComboBox().getSelectedIndex();
            view.getTextFieldIdFilter().setEnabled(selected == 0);
            view.getTextFieldDayFilter().setEnabled(selected == 1);
            view.getDateFilterFTxTF().setEnabled(selected == 2);
        });
    }

    public void chooseMenuOption() {
        view.setVisible(true);
    }

    // Utilidad para parsear fechas en formato dd/mm/yy
    private java.time.LocalDate parseDate(String text) {
        String[] parts = text.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        // Ajuste para años de dos dígitos
        if (year < 100) year += 2000;
        return java.time.LocalDate.of(year, month, day);
    }
}