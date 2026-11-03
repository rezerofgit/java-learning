class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int jumps = 0;       // 跳跃次数
        int currentEnd = 0;  // 当前跳跃能到达的最远边界
        int farthest = 0;    // 下一步能到达的最远位置

        // 遍历到倒数第二个元素即可（最后一个位置无需再跳）
        for (int i = 0; i < n - 1; i++) {
            // 更新当前能到达的最远位置
            farthest = Math.max(farthest, i + nums[i]);

            // 到达当前跳跃的边界，必须再跳一次
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // 更新下一跳的边界

                // 提前结束：已能到达或越过终点
                if (currentEnd >= n - 1) break;
            }
        }
        return jumps;
    }
}