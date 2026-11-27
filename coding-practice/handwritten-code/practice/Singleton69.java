class Solution {
    public int mySqrt(int x) {
        // 0 和 1 直接返回
        if (x < 2) return x;

        // 在 [1, x/2] 范围内二分查找，避免 mid*mid 溢出
        int left = 1, right = x / 2;
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 用除法代替乘法，防止 mid * mid 溢出 int
            if (mid <= x / mid) {
                result = mid;      // mid 平方 <= x，可能是答案，继续向右找更大的
                left = mid + 1;
            } else {
                right = mid - 1;   // mid 平方 > x，向左收缩
            }
        }
        return result;
    }
}