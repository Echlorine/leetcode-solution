import java.util.*;

class Solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for (int left = 0; left < nums.length - 2; left++) {
            int right = left + 1;
            while (right < nums.length - 1) {
                int target = nums[left] + nums[right];
                int index = binary_search(nums, target, right, nums.length);
                num += index - right;
                right++;
            }
        }
        return num;
    }
    
    public int binary_search(int[] nums, int target, int begin, int end) {
        int left = begin, right = end;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return left;
    }
}