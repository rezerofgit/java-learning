class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // 当前能到达的最远下标

        for (int i = 0; i < nums.length; i++) {
            // 当前下标已超出可达范围，无法继续前进
            if (i > maxReach) {
                return false;
            }
            // 更新能到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 提前结束：已能到达最后一个位置
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}