class Solution {
    public int totalNQueens(int n) {
        // 记录已被占用的列、主对角线（row-col）、副对角线（row+col）
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        return backtrack(0, n, cols, diag1, diag2);
    }

    private int backtrack(int row, int n,
                          Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        // 所有行都放置完毕，找到一种解
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            // 冲突检测：同列、同主对角线、同副对角线
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            // 放置皇后
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            count += backtrack(row + 1, n, cols, diag1, diag2);

            // 撤销
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
        return count;
    }
}