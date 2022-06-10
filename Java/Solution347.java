import java.util.*;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> ans = new HashMap<>();
        Map<Integer, List<Integer>> sna = new TreeMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++)
            ans.put(nums[i], ans.getOrDefault(nums[i], 0) + 1);
        int[] temp = new int[ans.size()];
        int i = 0;
        for(int key: ans.keySet()) {
            temp[i] = ans.get(key);
            List<Integer> t = sna.getOrDefault(temp[i], new ArrayList<Integer>());
            t.add(key);
            sna.put(temp[i], t);
            i++;
        }
        Arrays.sort(temp);
        i = 0;
        while (i < k) {
            List<Integer> t = sna.get(temp[temp.length - 1 - i]);
            for (int val : t) {
                res[i] = val;
                i++;
            }
        }
        return res;
    }
}