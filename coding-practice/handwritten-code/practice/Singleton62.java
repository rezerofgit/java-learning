class Solution {
    public int uniquePaths(int m, int n) {
        // dp[j] 表示到达当前行第 j 列的路径数
        int[] dp = new int[n];
        // 第一行所有位置都只有 1 种走法（一直向右）
        Arrays.fill(dp, 1);

        // 从第二行开始逐行计算
        for (int i = 1; i < m; i++) {
            // 第一列只有 1 种走法（一直向下），dp[0] 保持为 1
            for (int j = 1; j < n; j++) {
                // 到达 (i,j) 的路径数 = 上方 (i-1,j) + 左方 (i,j-1)
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}