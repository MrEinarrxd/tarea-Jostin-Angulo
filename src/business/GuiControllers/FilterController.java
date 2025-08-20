package business.GuiControllers;

import java.time.LocalDate;

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
                        LocalDate[] dateRange = getSelectedDateRange();
                        Object[] clients = usersController.filterUsersByDateRange(dateRange[0], dateRange[1], Utils.DateList);
                        if (clients == null || clients.length == 0) {
                            JOptionPane.showMessageDialog(view, "No hay clientes con citas en ese rango.");
                        } else {
                            String result = "";
                            for (int i = 0; i < clients.length; i++) {
                                result += clients[i] + "\n";
                            }
                            JOptionPane.showMessageDialog(view, result);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(view, "Rango de fechas inválido");
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

    private LocalDate[] getSelectedDateRange() {
        String rango = view.getDateFilterFTxTF().getText().trim();
        String[] fechas = rango.split("-");
        LocalDate[] dateRange = new LocalDate[2];
        for (int i = 0; i < 2; i++) {
            String[] parts = fechas[i].trim().split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            dateRange[i] = LocalDate.of(year, month, day);
        }
        return dateRange;
    }

    public void showMenu() {
        view.setVisible(true);
    }
}
