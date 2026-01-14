class Solution {
    boolean isValid(char[][] board, int n, int row, int col) {
        //Row
        for (int i = 0; i < n; i++) {
            if (i != col && board[row][i] == 'Q') {
                return false;
            }
        }
        //Column
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][col] == 'Q') {
                return false;
            }
        }
        //Right down diagonal
        int tr = row + 1;
        int tc = col + 1;
        while (tr < n && tc < n) {
            if (board[tr][tc] == 'Q') {
                return false;
            }
            tr++;
            tc++;
        }

        //Right up diagonal
        tr = row - 1;
        tc = col + 1;
        while (tr >= 0 && tc < n) {
            if (board[tr][tc] == 'Q') {
                return false;
            }
            tr--;
            tc++;
        }
        //left up diagonal
        tr = row - 1;
        tc = col - 1;
        while (tr >= 0 && tc >= 0) {
            if (board[tr][tc] == 'Q') {
                return false;
            }
            tr--;
            tc--;
        }

        //left down diagonal
        tr = row + 1;
        tc = col - 1;
        while (tr < n && tc >= 0) {
            if (board[tr][tc] == 'Q') {
                return false;
            }
            tr++;
            tc--;
        }

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(board, n, 0, ans);
        return ans;
    }

    void helper(char[][] board, int n, int row, List<List<String>> ans) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            ans.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            board[row][col] = 'Q';
            if (isValid(board, n, row, col)) {
                helper(board, n, row + 1,ans);
            }
            board[row][col] = '.';
        }
        return;
    }

}