package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainBottunGui extends JFrame {
    public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                MainBottunGui frame = new MainBottunGui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    }

    private static final long serialVersionUID = 1L;
    private JPanel topPanel;
    private JPanel centerPanel;

    private JLabel lblAddUser;
    private JLabel lblUserList;
    private JLabel lblUserFind;

    private JButton btnAddUser;
    private JButton btnUserList;
    private JButton btnUserFind;



    public MainBottunGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        this.setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(topPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
        contentPane.add(centerPanel, BorderLayout.CENTER);

        lblAddUser = new JLabel("Agregar Usuario:");
        lblUserList = new JLabel("Lista de Usuarios:");
        lblUserFind = new JLabel("Consultar Usuario:");
        
        btnAddUser = createButton("Agregar");
        btnUserList = createButton("Lista");
        btnUserFind = createButton("Consultar");

    centerPanel.add(createPair(lblAddUser.getText(), btnAddUser));
    centerPanel.add(createPair(lblUserList.getText(), btnUserList));
    centerPanel.add(createPair(lblUserFind.getText(), btnUserFind));

    }

    public JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    public void init() {
    this.setVisible(true);
    }

    private JPanel createPair(String labelText, JButton button) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(labelText), BorderLayout.NORTH);
        p.add(button, BorderLayout.CENTER);
        return p;
    }

    public JButton getBtnAddUser() { return btnAddUser; }

    public JButton getBtnUserList() { return btnUserList; }

    public JButton getBtnUserFind() { return btnUserFind; }
}