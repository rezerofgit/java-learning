class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // 1. 跳过末尾的空格
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. 从后向前统计最后一个单词的字符数
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}