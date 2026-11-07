class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // key: 排序后的字符串，value: 该组的所有异位词
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 将字符串排序后作为分组的唯一标识
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 将该字符串加入对应的分组
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}