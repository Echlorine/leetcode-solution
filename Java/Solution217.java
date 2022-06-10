import java.util.*;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        return set.size() != nums.length;
    }
}