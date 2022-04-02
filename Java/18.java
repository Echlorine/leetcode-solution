import java.util.*;

class Solution18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len=nums.length, begin=0, end=len-1;
        for (int i=0; i<len; i++){
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j=i+1; j<len; j++){
                if (j != i+1 && nums[j] == nums[j-1])
                    continue;
                begin=j+1;
                end=len-1;
                for (int k=j+1; k<len; k++){
                    if (begin >= end)
                        break;
                    if ( begin != j +1 && nums[begin] == nums[begin-1])
                        {begin++; continue;}
                    if (nums[i] + nums[j] + nums[begin] + nums[end] < target)
                        {begin++; continue;}
                    if (nums[i] + nums[j] + nums[begin] + nums[end] > target)
                        {end--; continue;}
                    if (nums[i] + nums[j] + nums[begin] + nums[end] == target){
                        List<Integer> res = new ArrayList<Integer>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[begin]);
                        res.add(nums[end]);
                        ans.add(res);
                        begin++;
                    }
                }
            }
        }
        return ans;
    }
} 