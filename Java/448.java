import java.util.*;

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            res.add(i + 1);
        for (int i = 0; i < nums.length; i++)
            res.set(nums[i] - 1, -1);
        res.removeIf(i -> (i == -1));;
        return res;
    }
}