package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ListGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

     @SuppressWarnings("unused")
    public ListGui(String resultText) {
        setTitle("Resultado del Filtro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblTitle = new JLabel("Resultado del Filtro");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitle, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setText(resultText);

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        JPanel panelSouth = new JPanel();
        panelSouth.add(btnCerrar);
        contentPane.add(panelSouth, BorderLayout.SOUTH);
    }

    public void setResultText(String text) {
        textArea.setText(text);
    }
}