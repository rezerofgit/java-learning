class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        // dp[j] 表示到达当前行第 j 列的路径数
        int[] dp = new int[n];
        // 起点无障碍时，第一列初始路径数为 1
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // 逐行计算
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < n; j++) {
                // 遇到障碍物，该位置路径数为 0
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                // 第一列只能由上方到达，dp[0] 已初始化，跳过
                if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1]; // 上方 + 左方
                }
            }
        }
        return dp[n - 1];
    }
}