class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0; // 进位

        // 从末位开始逐位相加
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2); // 当前位
            carry = sum / 2;    // 进位
        }

        // 反转得到正确顺序
        return sb.reverse().toString();
    }
}