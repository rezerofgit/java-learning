class Solution {
    public int[] plusOne(int[] digits) {
        // 从末位开始遍历，模拟进位
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // 当前位加 1，无需进位，直接返回
                return digits;
            }
            digits[i] = 0;        // 当前位为 9，变为 0，继续向高位进位
        }

        // 所有位都是 9（如 999 → 1000），需要扩容一位
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}