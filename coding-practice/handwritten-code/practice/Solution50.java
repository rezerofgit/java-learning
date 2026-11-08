class Solution {
    public double myPow(double x, int n) {
        // 转 long 处理 n = Integer.MIN_VALUE 的边界（-n 会溢出）
        long N = n;

        // 处理负指数
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        // 快速幂：按二进制位迭代
        while (N > 0) {
            // 当前二进制位为 1，乘入结果
            if ((N & 1) == 1) {
                result *= currentProduct;
            }
            // 底数平方，指数右移一位
            currentProduct *= currentProduct;
            N >>= 1;
        }
        return result;
    }
}