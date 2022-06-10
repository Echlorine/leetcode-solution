import java.util.*;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0, last = -1;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                if (nums1[p1] != last) {
                    res.add(nums1[p1]);
                    last = nums1[p1];
                    }
                p1++;
                p2++;
            }
            else if (nums1[p1] < nums2[p2]) {
                p1++;
            }
            else p2++;
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++)
            r[i] = res.get(i);
        return r;
    }
}