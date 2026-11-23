class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;   // 是否出现过数字
        boolean seenDot = false;     // 是否出现过小数点
        boolean seenExp = false;     // 是否出现过指数符号 e/E
        boolean digitAfterExp = true; // e 之后是否已有数字（初始为 true 便于处理无 e 的情况）

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                digitAfterExp = true;
            } else if (c == '+' || c == '-') {
                // 符号只能出现在开头或 e/E 的紧跟位置
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // 小数点不能重复，且不能出现在 e/E 之后
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // e/E 不能重复，且前面必须出现过数字
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                digitAfterExp = false; // 重置，等待 e 之后的数字
            } else {
                // 出现非法字符
                return false;
            }
        }
        // 最终必须出现过数字，且 e 之后必须有数字
        return seenDigit && digitAfterExp;
    }
}