class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            // 1. 贪心确定当前行能放下的单词范围 [i, j)
            int lineLen = words[i].length();
            int j = i + 1;
            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length(); // 加上空格 + 下一个单词
                j++;
            }

            StringBuilder sb = new StringBuilder();

            // 2. 最后一行 或 只有一个单词：左对齐，单词间单空格，末尾补空格
            if (j == n || j - i == 1) {
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(' ');
                    sb.append(words[k]);
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                // 3. 普通行：均匀分配空格
                int wordsCount = j - i;
                int totalSpaces = maxWidth - (lineLen - (wordsCount - 1)); // 除去单词间已有空格的纯空格数
                int gap = totalSpaces / (wordsCount - 1);       // 每个间隙的基础空格数
                int extra = totalSpaces % (wordsCount - 1);     // 余数，前 extra 个间隙多一个空格

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = gap + (k - i < extra ? 1 : 0);
                        for (int s = 0; s < spaces; s++) {
                            sb.append(' ');
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = j; // 处理下一行
        }
        return result;
    }
}