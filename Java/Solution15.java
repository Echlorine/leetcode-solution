import java.util.*;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        int begin=0, end=len -1;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i=0;i<len;i++){
            if (i !=0 && nums[i] == nums[i-1])
                continue;
            begin=i+1;
            end = len - 1;
            for (int j=i+1; j<len; j++){
                if (begin>=end)
                    break;
                if (begin-1 != i && nums[begin] == nums[begin-1])
                    {begin++;continue;}
                if (nums[i] + nums[begin] + nums[end]<0)
                    {begin++;continue;}
                if (nums[i] + nums[begin] + nums[end]==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    ans.add(list);
                    begin++;
                }
                if (nums[i] + nums[begin] + nums[end]>0)
                    end--;
            }
        }
        return ans;
    }
}