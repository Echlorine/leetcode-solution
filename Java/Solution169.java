import java.util.*;

class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        for (int k : map.keySet())
            if (map.get(k) > nums.length / 2) return k;
        return 0;
    }

    public int majority(int[] nums) {
        // Boyer-Moore 投票算法
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                res = nums[i];
            if (res == nums[i]) count++;
            else count--;
        }
        return res;
    }
}