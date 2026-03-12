import javax.swing.*;
import java.awt.*;

public class TTTBoard extends JPanel {
    public TTTWindow window;
    public TTTGame game;
    public TTTTileButton[] buttons;

    public TTTBoard(TTTWindow window) {
        super();

        this.window = window;
        game = new TTTGame();
        buttons = new TTTTileButton[game.size * game.size];

        setLayout(new GridLayout(game.size, game.size));

        for(int i = 0; i < game.size * game.size; i++) {
            buttons[i] = new TTTTileButton(this, i);
            add(buttons[i]);
        }

        updateBoard();
    }

    public void updateBoard() {
        for(int i = 0; i < buttons.length; i++) {
            String owner = game.getOwner(i);

            buttons[i].setText(String.format("%s", owner));
        }
    }

    public boolean makeMove(int id) {
        boolean isSuccessful = game.tryMove(id);

        updateBoard();

        if(!isSuccessful) {
            JOptionPane.showMessageDialog(window, "Oops! Illegal Move!");
        }

        String winner = game.testWin();
        if(winner != null) {
            JOptionPane.showMessageDialog(window, String.format("%s Wins! Congrats!", winner));
            game = new TTTGame();
            updateBoard();
        }

        if(game.testTie()) {
            JOptionPane.showMessageDialog(window, "Looks like there are no squares left. Its a tie!");
            game = new TTTGame();
            updateBoard();
        }

        return  isSuccessful;
    }
}
