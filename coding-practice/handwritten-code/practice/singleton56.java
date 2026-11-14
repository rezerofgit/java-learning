class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 1. 按区间起点升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        // 2. 遍历区间，合并重叠部分
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // 有重叠：当前区间终点 >= 下一区间起点，合并（取较大终点）
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                // 无重叠：当前区间已确定，加入结果，开始处理新区间
                result.add(current);
                current = next;
            }
        }

        // 3. 最后一个区间加入结果
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}