class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序：让相同元素相邻，便于去重
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path,
                           int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已使用，跳过
            if (used[i]) continue;

            // 去重：同一层中，若当前元素与前一个相同，且前一个未被使用，则跳过
            // 保证相同元素在排列中的相对顺序固定，避免重复排列
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(result, path, nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}