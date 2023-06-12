package pacman;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pacman extends JFrame {

    public Pacman() {
        setTitle("Pacman");
        setSize(380, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new Model();
        add(panel);
    }

    public static void main(String[] args) {
        Pacman pac = new Pacman();
        pac.setVisible(true);
    }
}
