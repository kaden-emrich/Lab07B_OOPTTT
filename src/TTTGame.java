public class TTTGame {
    public static final int[] WIN_MASKS = {
            0b111000000, // first row
            0b000111000, // second row
            0b000000111, // third row
            0b100100100, // first column
            0b010010010, // second column
            0b001001001, // third column
            0b001010100, // forward diagonal
            0b100010001  // backward diagonal
    };

    public int p1Tiles;
    public int p2Tiles;
    public int turn;
    public int size = 3;

    public TTTGame() {
        p1Tiles = 0;
        p2Tiles = 0;
        turn = 1;
    }

    public boolean isValidMove(int move) {
        int mask = 0b1 << move;

        if((p1Tiles & mask) == mask) {
            return false;
        }

        return (p2Tiles & mask) != mask;
    }

    public boolean tryMove(int move) {
        if(!isValidMove(move)) {
            return false;
        }

        // finish later
        int moveBit = 0b1 << move;
        if(turn == 1) {
            p1Tiles = p1Tiles | moveBit;
        }
        else {
            p2Tiles = p2Tiles | moveBit;
        }

        nextTurn();
        return true;
    }

    public String getOwner(int tileIndex) {
        int tileBit = 0b1 << tileIndex;

        if((p1Tiles & tileBit) == tileBit) {
            return "X";
        }

        if((p2Tiles & tileBit) == tileBit) {
            return "O";
        }

        return " ";
    }

    public boolean testTie() {
        return (p1Tiles | p2Tiles) == 0b111111111;
    }

    public String testWin() {
        for(int mask : WIN_MASKS) {
            if((p1Tiles & mask) == mask) {
                return "X";
            }

            if((p2Tiles & mask) == mask) {
                return "O";
            }
        }

        return null;
    }

    public void nextTurn() {
        if(turn == 2) {
            turn = 1;
            return;
        }
        turn = 2;
    }
}
