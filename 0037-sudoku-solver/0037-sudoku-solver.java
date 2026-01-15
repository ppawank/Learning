class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solve(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] grid, int row, int col, char digit) {

        for (int i = 0; i < 9; i++) {
            //Col check
            if (grid[i][col] == digit) {
                return false;
            }
            //Row check
            if (grid[row][i] == digit) {
                return false;
            }
            //Sub-box 3*3 check
            if (grid[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == digit) {
                return false;
            }
        }
        return true;
    }
}