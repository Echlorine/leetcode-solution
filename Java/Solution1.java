import java.util.*;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (ans.containsKey(target - nums[i])){
                res[0] = ans.get(target - nums[i]); res[1] = i;
                return res;
            }
            ans.put(nums[i], i);
        }
        return res;
    }
}