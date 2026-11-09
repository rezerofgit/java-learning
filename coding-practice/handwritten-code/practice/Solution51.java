class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 记录已被占用的列、主对角线（row-col）、副对角线（row+col）
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); // row - col
        Set<Integer> diag2 = new HashSet<>(); // row + col

        // 初始化棋盘，全为 '.'
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(result, board, 0, n, cols, diag1, diag2);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, int n,
                           Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        // 所有行都放置完毕，收集结果
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // 冲突检测：同列、同主对角线、同副对角线
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            // 放置皇后
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(result, board, row + 1, n, cols, diag1, diag2);

            // 撤销
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}