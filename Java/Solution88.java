class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n;
        while (m > 0 && n > 0) {
            int t = 0;
            if (nums1[m - 1] > nums2[n - 1]) {
                t = nums1[m - 1];
                m--;
            } else {
                t = nums2[n - 1];
                n--;
            }
            nums1[l - 1] = t;
            l--;
        }
        if (n == 0) return;
        while (n > 0) {
            nums1[l - 1] = nums2[n - 1];
            l--;
            n--;
        }
    }
}