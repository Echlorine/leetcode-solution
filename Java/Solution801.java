class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        // d[i] 表示使得nums1[0:i]和nums2[0:i]严格递增的最少交换次数
        int[] d = new int[nums1.length];
        int[] p = new int[nums1.length];
        // 边界
        d[0] = 0; p[0] = 1;
        // d
        for (int i = 1; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE; p[i] = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                d[i] = Math.min(d[i], d[i - 1]);
                p[i] = Math.min(p[i], p[i - 1] + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                d[i] = Math.min(d[i], p[i - 1]);
                p[i] = Math.min(p[i], d[i - 1] + 1);
            }
        }
        return Math.min(d[nums1.length - 1], p[nums1.length - 1]);
    }
}