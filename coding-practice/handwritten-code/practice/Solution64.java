class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp[j] 表示到达当前行第 j 列的最小路径和
        int[] dp = new int[n];

        // 初始化第一行：只能从左边走过来
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // 逐行计算
        for (int i = 1; i < m; i++) {
            // 第一列只能从上方走过来
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                // 取上方和左方中的较小值
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}