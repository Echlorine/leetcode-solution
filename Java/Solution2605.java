class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE, n3 = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            n1 = Math.min(n1, nums1[i]);
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            n2 = Math.min(n2, nums2[i]);
            if (set.contains(nums2[i])) n3 = Math.min(n3, nums2[i]);
        }
        if (n3 != Integer.MAX_VALUE) return n3;
        return Math.min(n1 * 10 + n2, n2 * 10 + n1);
    }
}