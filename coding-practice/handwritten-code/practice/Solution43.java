class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {
            // 每次处理较矮的一侧，其能存的水由该侧的最大高度决定
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 更新左侧最大高度，不存水
                } else {
                    water += leftMax - height[left]; // 存水
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // 更新右侧最大高度，不存水
                } else {
                    water += rightMax - height[right]; // 存水
                }
                right--;
            }
        }
        return water;
    }
}