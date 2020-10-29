package lesson1.problem7;

// O(n) time | O(1) space
// 20 mins to solve
public class TicTacToe {
    private final int[][] board;

    public TicTacToe(int n) {
        this.board = new int[n][n];
    }

    public int move(int x, int y, int player) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length) return -1;
        if (board[x][y] != 0) return -1;

        board[x][y] = player;

        return (checkWinner(x, y, player)) ? 0 : player;
    }

    private boolean checkWinner(int x, int y, int player) {
        return (   checkHorizontal(y, player)
                || checkVertical(x, player)
                || checkDiagonalDownRight(player)
                || checkDiagonalUpRight(player)  );
    }

    private boolean checkHorizontal(int y, int player) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][y] != player) return false;
        }
        return true;
    }

    private boolean checkVertical(int x, int player) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[x][i] != player) return false;
        }
        return true;
    }

    private boolean checkDiagonalDownRight(int player) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][i] != player) return false;
        }
        return true;
    }

    private boolean checkDiagonalUpRight(int player) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][board.length - 1 - i] != player) return false;
        }
        return true;
    }
}


//Design a Tic-tac-toe game that is played between two players on a n x n grid.
//e.g. let game = new TicTacToe(3);
//game.move(0,0,1);

// |0|0|0|
// |0|1|0|
// |0|0|0|