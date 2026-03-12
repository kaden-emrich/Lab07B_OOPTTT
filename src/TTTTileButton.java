import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTTileButton extends JButton {
    public int id;
    public TTTBoard board;

    public TTTTileButton(TTTBoard board, int id) {
        super("");
        this.board = board;
        this.id = id;
        setFont(new Font("Arial", Font.PLAIN, 30));
        setFocusPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeMove();
            }
        });
    }

    public void makeMove() {
        boolean isSuccessful = board.makeMove(id);

        if(isSuccessful) return;
    }
}
