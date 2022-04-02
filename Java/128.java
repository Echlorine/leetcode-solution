import java.util.*;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        int res = 0, temp = 0, value = 0;
        // 构造哈希表
        for (int i = 0; i < nums.length; i++)
            ans.put(nums[i], nums[i]);
        for (int i = 0; i < nums.length; i++){
            temp = 1;
            value = nums[i];
            if (ans.getOrDefault(value - 1, -1) != -1) continue;
            while (ans.containsKey(value + 1))
                {temp++; value++;}
            res = Math.max(res, temp);
        }
        return res;
    }
}