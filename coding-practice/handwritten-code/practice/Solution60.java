class Solution {
    public String getPermutation(int n, int k) {
        // 1. 预计算阶乘，fact[i] = i!
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // 2. 初始化可选数字列表 1 ~ n
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // 将 k 转为从 0 开始的索引
        k--;

        StringBuilder sb = new StringBuilder();
        // 3. 逐位确定每一位的数字
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];      // 当前位在候选列表中的下标
            sb.append(nums.get(index));   // 取出并追加到结果
            nums.remove(index);           // 从候选中移除
            k %= fact[i];                 // 更新剩余 k
        }

        return sb.toString();
    }
}