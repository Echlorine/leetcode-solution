class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1, m2, num1 = nums1.length, num2 = nums2.length;
        int j=0, k=0; // 两个数组的指针
        int res1=0, res2=0;
        //确定中位数位置
        m1 = (num1 + num2) % 2 == 1 ? (num1 + num2) / 2 + 1 : (num1 + num2) / 2;
        m2 = (num1 + num2) % 2 == 1 ? 0 : (num1 + num2) / 2 + 1;
        for (int i = 0; i<m1; i++) {
            if (k == num2 || j < num1 && nums1[j] < nums2[k]) {
                res1 = nums1[j];
                j++;
                continue;
            }
            if (j == num1 || k < num2 && nums1[j] >= nums2[k]) {
                res1 = nums2[k];
                k++;
                continue;
            }
        }
        if (m2 == 0)
            return (double) res1;
        for (int i = m1; i<m2; i++) {
            if (k == num2 || j < num1 && nums1[j] < nums2[k]) {
                res2 = nums1[j];
                break;
            }
            if (j == num1 || k < num2 && nums1[j] >= nums2[k]) {
                res2 = nums2[k];
                break;
            }
        }
        return (res1 + res2) / 2.0;
    }
}