import javax.swing.*;
import java.awt.GridLayout;
// import yourFile;

public class LoginScreen extends JFrame {
    protected JTextField usernameField;
    protected JPasswordField passwordField;
    private CSVReader csvReader;
    private LoginValidator loginValidator;

    public LoginScreen() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        csvReader = new CSVReader("src/public/csv/data.csv", ",");
        loginValidator = new LoginValidator(csvReader);

        loginButton.addActionListener(new LoginButtonListener(this, loginValidator));
        cancelButton.addActionListener(new CancelButtonListener());

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(cancelButton);
    }

    // public void openFile() {
    //     Window window = new window();
    //     window.setVisible(true);
    //     window.setLocationRelativeTo(null);
    // }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
            }
        });
    }
}
