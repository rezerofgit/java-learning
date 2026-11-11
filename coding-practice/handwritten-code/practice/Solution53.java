class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane 算法：curMax 表示以当前元素结尾的最大子数组和
        int curMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 若前缀和为负，则舍弃之前的部分，从当前元素重新开始
            curMax = Math.max(nums[i], curMax + nums[i]);
            // 更新全局最大值
            maxSum = Math.max(maxSum, curMax);
        }
        return maxSum;
    }
}