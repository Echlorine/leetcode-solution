import java.util.*;

class TwoSum {
    private List<Integer> data;
    private Map<Integer, Integer> hashtable;

    public TwoSum() {
        data = new ArrayList<>();
    }
    
    public void add(int number) {
        data.add(number);
    }
    
    public boolean find(int value) {
        hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < data.size(); ++i) {
            if (hashtable.containsKey(value - data.get(i))) return true;
            hashtable.put(data.get(i), i);
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

class Solution170 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}