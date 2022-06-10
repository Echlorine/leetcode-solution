import java.util.*;

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
         * 滑动窗口
         */
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            if (set.size() <= k) {
                if (right < nums.length - 1) {
                    // 窗口右移
                    if (set.contains(nums[right])) return true;
                    else set.add(nums[right++]);
                }
                else break;
            }
            else {
                // 窗口左移
                left++;
                set.remove(nums[left - 1]);
            }
        }
        return set.contains(nums[right]);
    }
}