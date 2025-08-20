package presentation;

import javax.swing.*;
import java.awt.*;

public class MainBottunGui extends JFrame {
    private JComboBox<String> comboBox;
    private JButton btnContinue;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainBottunGui frame = new MainBottunGui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainBottunGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Título superior
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
        JLabel lblTitle = new JLabel("Sistema de Veterinaria");
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        panelNorth.add(lblTitle);
        panelNorth.add(Box.createVerticalStrut(10));
        JLabel lblQuestion = new JLabel("¿Qué acción desea realizar?");
        lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        panelNorth.add(lblQuestion);
        getContentPane().add(panelNorth, BorderLayout.NORTH);

        // Centro con combo y botón
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        comboBox = new JComboBox<>(new String[] {
            "Agregar usuario", "Listado de usuarios", "Consultar usuario"
        });
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panelCenter.add(comboBox);
        panelCenter.add(Box.createVerticalStrut(20));

        btnContinue = new JButton("Continuar");
        btnContinue.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(btnContinue);

        getContentPane().add(panelCenter, BorderLayout.CENTER);
    }

    // Métodos públicos para acceder al combo y al botón desde el controlador
    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public JButton getBtnContinue() {
        return btnContinue;
    }

    public void init() {
        setVisible(true);
    }
}