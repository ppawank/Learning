class Solution {
    boolean isValid(boolean[][] board, int n, int row, int col) {

        //Row
        for (int i = 0; i < n; i++) {
            if (i != col && board[row][i]) {
                return false;
            }
        }
        //Column
        for (int j = 0; j < n; j++) {
            if (j != row && board[j][col]) {
                return false;
            }
        }
        //Right down digonal
        int tr = row + 1;
        int tc = col + 1;
        while (tr < n && tc < n) {
            if (board[tr][tc]) {
                return false;
            }
            tr++;
            tc++;
        }
        //Right up digonal
        tr = row - 1;
        tc = col + 1;
        while (tr >= 0 && tc < n) {
            if (board[tr][tc]) {
                return false;
            }
            tr--;
            tc++;
        }
        //left up digonal
        tr = row - 1;
        tc = col - 1;
        while (tr >= 0 && tc >= 0) {
            if (board[tr][tc]) {
                return false;
            }
            tr--;
            tc--;
        }
        //left down digonal
        tr = row + 1;
        tc = col - 1;
        while (tr < n && tc >= 0) {
            if (board[tr][tc]) {
                return false;
            }
            tr++;
            tc--;
        }

        return true;

    }

    int count = 0;

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        helper(board, n, 0);
        return count;
    }

    public void helper(boolean[][] board, int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        //Adding queen row wise
        for (int col = 0; col < n; col++) {
            board[row][col] = true;
            if (isValid(board, n, row, col)) {
                //if queen placed well
                helper(board, n, row + 1);
            }
            board[row][col] = false;
        }
        return;
    }
}