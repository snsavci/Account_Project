import javax.swing.*;
import java.awt.*;

public class AccountForm extends JFrame {

    public AccountForm() {
        setTitle("Create New Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField firstName = new JTextField(15);
        JTextField lastName = new JTextField(15);
        JTextField dob = new JTextField(15);
        JTextField email = new JTextField(15);
        JPasswordField password = new JPasswordField(15);
        JPasswordField confirmPassword = new JPasswordField(15);
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(Color.WHITE);
        JButton submit = new JButton("✅ Submit");
        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(new Color(0, 102, 204));

        addField(mainPanel, gbc, 0, "First Name:", firstName);
        addField(mainPanel, gbc, 1, "Last Name:", lastName);
        addField(mainPanel, gbc, 2, "Date of Birth (dd/mm/yyyy):", dob);
        addField(mainPanel, gbc, 3, "Email:", email);
        addField(mainPanel, gbc, 4, "Password:", password);
        addField(mainPanel, gbc, 5, "Confirm Password:", confirmPassword);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        mainPanel.add(showPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        submit.setBackground(new Color(0, 153, 76));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        mainPanel.add(submit, gbc);

        gbc.gridy = 8;
        mainPanel.add(resultLabel, gbc);

        showPassword.addActionListener(e -> {
            char echoChar = showPassword.isSelected() ? (char) 0 : '•';
            password.setEchoChar(echoChar);
            confirmPassword.setEchoChar(echoChar);
        });

        submit.addActionListener(e -> {
            String fn = firstName.getText();
            String ln = lastName.getText();
            String em = email.getText();
            String pw = new String(password.getPassword());
            String cpw = new String(confirmPassword.getPassword());
            String date = dob.getText();

            String result = Account.validateAccount(fn, ln, em, pw, cpw, date);
            resultLabel.setText(result);
        });

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addField(JPanel panel, GridBagConstraints gbc, int y, String label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    public static void main(String[] args) {
        new AccountForm();
    }
}
