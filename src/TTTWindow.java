import javax.swing.*;
import java.awt.*;

public class TTTWindow extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new TTTWindow();});
    }

    public TTTWindow() {
        super();
        buildGUI();
    }

    public void buildGUI() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int windowSize = Math.min(screenSize.width, screenSize.height) /2;

        setTitle("OPP TicTacToe");
        setSize(windowSize, windowSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        add(new TTTBoard(this), "Center");

        setVisible(true);
    }
}
