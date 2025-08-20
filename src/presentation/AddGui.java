package presentation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AddGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldMail;
    private JTextField textFieldPhone;
    private JComboBox<String> comboBox;
    private JButton btnAgregar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddGui frame = new AddGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddGui() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Panel superior (NORTH)
        JPanel panelNorth = new JPanel();
        panelNorth.setBorder(null);
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
        contentPane.add(panelNorth, BorderLayout.NORTH);

        JLabel lblSwithLabel = new JLabel("Seleccione el tipo de usuario que desea agregar");
        panelNorth.add(lblSwithLabel);

        comboBox = new JComboBox<>();
        comboBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Agregar Cliente", "Agregar Veterinario", "Agregar Asistente"}));
        panelNorth.add(comboBox);

        // Panel central (CENTER) con GridBagLayout para alinear campos y labels
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        // ID
        GridBagConstraints gbcLabelId = new GridBagConstraints();
        gbcLabelId.insets = new Insets(5, 5, 5, 5);
        gbcLabelId.anchor = GridBagConstraints.WEST;
        gbcLabelId.gridx = 0; gbcLabelId.gridy = 0;
        panelCenter.add(new JLabel("ID:"), gbcLabelId);

        GridBagConstraints gbcFieldId = new GridBagConstraints();
        gbcFieldId.insets = new Insets(5, 5, 5, 5);
        gbcFieldId.anchor = GridBagConstraints.WEST;
        gbcFieldId.gridx = 1; gbcFieldId.gridy = 0;
        textFieldId = new JTextField(12);
        panelCenter.add(textFieldId, gbcFieldId);

        // Nombre
        GridBagConstraints gbcLabelName = new GridBagConstraints();
        gbcLabelName.insets = new Insets(5, 5, 5, 5);
        gbcLabelName.anchor = GridBagConstraints.WEST;
        gbcLabelName.gridx = 0; gbcLabelName.gridy = 1;
        panelCenter.add(new JLabel("Nombre:"), gbcLabelName);

        GridBagConstraints gbcFieldName = new GridBagConstraints();
        gbcFieldName.insets = new Insets(5, 5, 5, 5);
        gbcFieldName.anchor = GridBagConstraints.WEST;
        gbcFieldName.gridx = 1; gbcFieldName.gridy = 1;
        textFieldName = new JTextField(12);
        panelCenter.add(textFieldName, gbcFieldName);

        // Correo
        GridBagConstraints gbcLabelMail = new GridBagConstraints();
        gbcLabelMail.insets = new Insets(5, 5, 5, 5);
        gbcLabelMail.anchor = GridBagConstraints.WEST;
        gbcLabelMail.gridx = 0; gbcLabelMail.gridy = 2;
        panelCenter.add(new JLabel("Correo:"), gbcLabelMail);

        GridBagConstraints gbcFieldMail = new GridBagConstraints();
        gbcFieldMail.insets = new Insets(5, 5, 5, 5);
        gbcFieldMail.anchor = GridBagConstraints.WEST;
        gbcFieldMail.gridx = 1; gbcFieldMail.gridy = 2;
        textFieldMail = new JTextField(12);
        panelCenter.add(textFieldMail, gbcFieldMail);

        // Teléfono
        GridBagConstraints gbcLabelPhone = new GridBagConstraints();
        gbcLabelPhone.insets = new Insets(5, 5, 5, 5);
        gbcLabelPhone.anchor = GridBagConstraints.WEST;
        gbcLabelPhone.gridx = 0; gbcLabelPhone.gridy = 3;
        panelCenter.add(new JLabel("Teléfono:"), gbcLabelPhone);

        GridBagConstraints gbcFieldPhone = new GridBagConstraints();
        gbcFieldPhone.insets = new Insets(5, 5, 5, 5);
        gbcFieldPhone.anchor = GridBagConstraints.WEST;
        gbcFieldPhone.gridx = 1; gbcFieldPhone.gridy = 3;
        textFieldPhone = new JTextField(12);
        panelCenter.add(textFieldPhone, gbcFieldPhone);

        // Botón Agregar
        GridBagConstraints gbcBtnAgregar = new GridBagConstraints();
        gbcBtnAgregar.insets = new Insets(5, 5, 5, 5);
        gbcBtnAgregar.gridx = 0; gbcBtnAgregar.gridy = 4; gbcBtnAgregar.gridwidth = 2;
        gbcBtnAgregar.anchor = GridBagConstraints.CENTER;
        btnAgregar = new JButton("Agregar");
        panelCenter.add(btnAgregar, gbcBtnAgregar);
    }

    // Métodos públicos para acceder a los campos desde el controlador
    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public JTextField getTextFieldId() {
        return textFieldId;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldMail() {
        return textFieldMail;
    }

    public JTextField getTextFieldPhone() {
        return textFieldPhone;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
}