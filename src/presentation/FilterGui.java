package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FilterGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldIdFilter;
    private JTextField textFieldDayFilter;
    private JFormattedTextField dateFilterFTxTF;
    private JComboBox<String> comboBox;
    private JButton btnSelectFilter;
    private JButton btnFiltrar;

     @SuppressWarnings("unused")
    public FilterGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel superior con combo y botón seleccionar filtro
        JPanel panelNorth = new JPanel();
        comboBox = new JComboBox<>(new String[] {"Id", "Día", "Fecha"});
        panelNorth.add(comboBox);

        btnSelectFilter = new JButton("Seleccionar Filtro");
        panelNorth.add(btnSelectFilter);

        contentPane.add(panelNorth, BorderLayout.NORTH);

        // Panel central con campos de filtro
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        // ID
        GridBagConstraints gbcLabelId = new GridBagConstraints();
        gbcLabelId.insets = new Insets(8, 8, 8, 8);
        gbcLabelId.anchor = GridBagConstraints.WEST;
        gbcLabelId.gridx = 0; gbcLabelId.gridy = 0;
        panelCenter.add(new JLabel("ID:"), gbcLabelId);

        GridBagConstraints gbcFieldId = new GridBagConstraints();
        gbcFieldId.insets = new Insets(8, 8, 8, 8);
        gbcFieldId.anchor = GridBagConstraints.WEST;
        gbcFieldId.gridx = 1; gbcFieldId.gridy = 0;
        textFieldIdFilter = new JTextField(15);
        panelCenter.add(textFieldIdFilter, gbcFieldId);

        // Día
        GridBagConstraints gbcLabelDay = new GridBagConstraints();
        gbcLabelDay.insets = new Insets(8, 8, 8, 8);
        gbcLabelDay.anchor = GridBagConstraints.WEST;
        gbcLabelDay.gridx = 0; gbcLabelDay.gridy = 1;
        panelCenter.add(new JLabel("Día:"), gbcLabelDay);

        GridBagConstraints gbcFieldDay = new GridBagConstraints();
        gbcFieldDay.insets = new Insets(8, 8, 8, 8);
        gbcFieldDay.anchor = GridBagConstraints.WEST;
        gbcFieldDay.gridx = 1; gbcFieldDay.gridy = 1;
        textFieldDayFilter = new JTextField(15);
        panelCenter.add(textFieldDayFilter, gbcFieldDay);

        // Fecha (rango)
        GridBagConstraints gbcLabelDate = new GridBagConstraints();
        gbcLabelDate.insets = new Insets(8, 8, 8, 8);
        gbcLabelDate.anchor = GridBagConstraints.WEST;
        gbcLabelDate.gridx = 0; gbcLabelDate.gridy = 2;
        panelCenter.add(new JLabel("Rango Fechas:"), gbcLabelDate);

        GridBagConstraints gbcFieldDate = new GridBagConstraints();
        gbcFieldDate.insets = new Insets(8, 8, 8, 8);
        gbcFieldDate.anchor = GridBagConstraints.WEST;
        gbcFieldDate.gridx = 1; gbcFieldDate.gridy = 2;
        dateFilterFTxTF = new JFormattedTextField();
        dateFilterFTxTF.setColumns(15);
        dateFilterFTxTF.setText("dd/mm/yyyy-dd/mm/yyyy");
        panelCenter.add(dateFilterFTxTF, gbcFieldDate);

        // Botón Filtrar
        GridBagConstraints gbcBtnFiltrar = new GridBagConstraints();
        gbcBtnFiltrar.insets = new Insets(8, 8, 8, 8);
        gbcBtnFiltrar.gridx = 0; gbcBtnFiltrar.gridy = 3; gbcBtnFiltrar.gridwidth = 2;
        gbcBtnFiltrar.anchor = GridBagConstraints.CENTER;
        btnFiltrar = new JButton("Filtrar");
        panelCenter.add(btnFiltrar, gbcBtnFiltrar);

        // Inicialmente solo el campo de ID está habilitado
        textFieldIdFilter.setEnabled(true);
        textFieldDayFilter.setEnabled(false);
        dateFilterFTxTF.setEnabled(false);

        // Listener para el botón seleccionar filtro
        btnSelectFilter.addActionListener(e -> {
            int selected = comboBox.getSelectedIndex();
            textFieldIdFilter.setEnabled(selected == 0);
            textFieldDayFilter.setEnabled(selected == 1);
            dateFilterFTxTF.setEnabled(selected == 2);
        });
    }

    // Métodos públicos para acceder a los campos desde el controlador
    public JComboBox<String> getComboBox() {
        return comboBox;
    }
    public JButton getBtnSelectFilter() {
        return btnSelectFilter;
    }
    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }
    public JTextField getTextFieldIdFilter() {
        return textFieldIdFilter;
    }
    public JTextField getTextFieldDayFilter() {
        return textFieldDayFilter;
    }
    public JFormattedTextField getDateFilterFTxTF() {
        return dateFilterFTxTF;
    }
}