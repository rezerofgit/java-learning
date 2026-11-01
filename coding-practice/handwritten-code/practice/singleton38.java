class Solution {
    public String multiply(String num1, String num2) {
        // 处理乘数为 0 的情况
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        // 结果最多 m + n 位
        int[] result = new int[m + n];

        // 从后往前逐位相乘，模拟竖式乘法
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                // 乘积叠加到对应位置：p2 为低位，p1 为高位
                int p1 = i + j, p2 = i + j + 1;
                int sum = digit1 * digit2 + result[p2];
                result[p2] = sum % 10;      // 当前位
                result[p1] += sum / 10;     // 进位加到高位
            }
        }

        // 跳过前导 0，构造结果字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (sb.length() == 0 && result[i] == 0) {
                continue; // 跳过前导 0
            }
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}