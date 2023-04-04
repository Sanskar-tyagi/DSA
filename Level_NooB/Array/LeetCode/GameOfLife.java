package Array.LeetCode;

public class GameOfLife {
    // ! https://leetcode.com/problems/game-of-life
    // The Approach here is to find the sum of all the 8 possible Neighbors
    // If the call is out of bound we will consider it as 0 and try to find the sum
    // of all.
    // then we will compare it to the conditions of problem by comparing the alive
    // (Because alive stands for 1 so the total some of all will just give us the
    // Living Neighbors)
    // and accordingly we will put the values in our temp board and later clone it
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] tempBoard = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveNeighbors = neighbor(board, r - 1, c - 1) + neighbor(board, r - 1, c) +
                        neighbor(board, r - 1, c + 1) + neighbor(board, r, c + 1) +
                        neighbor(board, r + 1, c + 1) + neighbor(board, r + 1, c) +
                        neighbor(board, r + 1, c - 1) + neighbor(board, r, c - 1);

                if (board[r][c] == 1) {
                    tempBoard[r][c] = (liveNeighbors < 2 || liveNeighbors > 3) ? 0 : 1;
                } else {
                    tempBoard[r][c] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            board[r] = tempBoard[r].clone();
        }
    }

    public int neighbor(int[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0) {
            return 0;
        }
        return 1;
    }
}
