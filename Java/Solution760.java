class Solution760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        // 遍历 B
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) map.put(nums2[i], new LinkedList<>());
            map.get(nums2[i]).add(i);
        }
        // 确定变为映射
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int t = map.get(nums1[i]).remove(0);
            res[i] = t;
        }
        return res;
    }
}