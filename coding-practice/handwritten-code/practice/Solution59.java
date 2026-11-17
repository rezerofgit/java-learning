class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        // 定义四个边界
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1; // 待填入的数字

        while (num <= n * n) {
            // 1. 从左到右填充上边界
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;

            // 2. 从上到下填充右边界
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 3. 从右到左填充下边界
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;

            // 4. 从下到上填充左边界
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}