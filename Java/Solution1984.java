import java.util.*;

class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = k - 1;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            res = Math.min(res, nums[right] - nums[left]);
            left++;
            right++;
        }
        return res;
    }
}