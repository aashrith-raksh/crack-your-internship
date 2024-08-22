package arrays;

public class WordSearch {

    // Set<List<Integer>> set = new HashSet<>();
    boolean ans = false;
    int idx = 0;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    ans = helper(board, word,
                            i, j,
                            board.length, board[0].length);
                    if (ans) {

                        return ans;
                    }
                    idx = 0;

                }
            }
        }

        return ans;
    }

    boolean helper(char[][] board, String word, int curRow, int curCol, int m, int n) {

        // List<Integer

        if (idx == word.length()) {
            return true;
        }

        if (curRow == m || curCol == n || curRow < 0 || curCol < 0) {
            return false;
        }

        // System.out.println("at: [" + curRow + "]" + "[" + curCol + "]\n");

        if (board[curRow][curCol] == '.') {
            return false;
        }

        if (board[curRow][curCol] != word.charAt(idx)) {
            return false;
        }

        if (board[curRow][curCol] == word.charAt(idx)) {
            // System.out.println("found " + board[curRow][curCol]);
            // System.out.println("current idx: " + idx);
            idx++;
            // System.out.println("udpated idx: " + idx);
            // System.out.println("--------------------------------\n");

        }

        board[curRow][curCol] = '.';

        // PROCESSING

        boolean temp = helper(board, word, curRow, curCol + 1, m, n) ||
                helper(board, word, curRow + 1, curCol, m, n) ||
                helper(board, word, curRow - 1, curCol, m, n) ||
                helper(board, word, curRow, curCol - 1, m, n);

        idx--;
        board[curRow][curCol] = word.charAt(idx);
        return temp;
    }

}
