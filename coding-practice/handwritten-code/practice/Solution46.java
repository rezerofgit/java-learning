class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path,
                           int[] nums, boolean[] used) {
        // 终止条件：路径长度等于数组长度，得到一个完整排列
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // 拷贝后加入结果
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 跳过已在当前排列中使用过的元素
            if (used[i]) continue;

            path.add(nums[i]);          // 做选择
            used[i] = true;             // 标记已使用
            backtrack(result, path, nums, used);
            used[i] = false;            // 撤销标记
            path.remove(path.size() - 1); // 撤销选择
        }
    }
}