class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j] 表示 s 的前 i 个字符与 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 初始化：p 中开头的连续 '*' 可以匹配空字符串
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '?' || pc == sc) {
                    // '?' 匹配任意单个字符，或字符相同
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' 匹配空串（dp[i][j-1]）或匹配一个字符（dp[i-1][j]）
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}