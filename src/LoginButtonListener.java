import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginButtonListener implements ActionListener {
    private LoginScreen loginScreen;
    private LoginValidator loginValidator;

    public LoginButtonListener(LoginScreen loginScreen, LoginValidator loginValidator) {
        this.loginScreen = loginScreen;
        this.loginValidator = loginValidator;
    }

    public void actionPerformed(ActionEvent e) {
        String username = loginScreen.usernameField.getText();
        String password = new String(loginScreen.passwordField.getPassword());

        try {
            if (loginValidator.validateLogin(username, password)) {
                loginScreen.openPacman();
                loginScreen.dispose();
            } else {
                JOptionPane.showMessageDialog(loginScreen, "Invalid username or password.");
            }
        } catch (InvalidLoginException ex) {
            JOptionPane.showMessageDialog(loginScreen, "Invalid login: " + ex.getMessage());
        }
    }
}
