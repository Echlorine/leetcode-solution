import java.util.*;

class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        int left = 0;
        // 窗口右移
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            if (map.containsKey(val)) { // 左移不会使答案增加，所以无需比较
                res = Math.max(res, sum);
                int index = map.get(val);
                for (int i = left; i <= index; i++) {
                    sum -= nums[i];
                    map.remove(nums[i]);
                }
                left = index + 1;
            }
            sum += val;
            map.put(val, right);
        }
        return Math.max(res, sum);
    }
}