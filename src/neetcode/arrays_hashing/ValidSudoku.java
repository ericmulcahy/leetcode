package neetcode.arrays_hashing;

public class ValidSudoku {
   
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } 
                // row and column check
                for (int z = 0; z < 9; z++) {
                    if (z != i && board[i][j] == board[z][j]) return false;
                    if (z != j && board[i][j] == board[i][z]) return false;
                }
                int left = i - (i % 3);
                int top = j - (j % 3);
                for (int z = left; z < left + 3; z++) {
                    for (int y = top; y < top + 3; y++) {
                        if ((z != i || y != j) && board[i][j] == board[z][y]) return false;
                    }
                }

            }
        }
        return true;
    }
}
