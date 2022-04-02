import java.util.*;

class Solution16 {
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int begin=0, end=len -1;
        int temp=0, value=0,res=0;
        Arrays.sort(nums);
        value = Math.abs(target - (nums[0] + nums[1] + nums[end]));
        res = nums[0] + nums[1] + nums[end];
        for (int i=0;i<len-2;i++){
            if (i !=0 && nums[i] == nums[i-1])
                continue;
            begin = i + 1;
            end = len - 1;
            if (begin >= end)
                break;
            for (int j=i+1; j<len-1; j++){
                if (begin >= end)
                    break;
                temp = Math.abs(target - (nums[i] + nums[begin] + nums[end]));
                if (temp <= value){
                    value = temp;
                    res = nums[i] + nums[begin] + nums[end];
                }
                if (target - (nums[i] + nums[begin] + nums[end])<0){
                    end--;
                    continue;
                }
                if (target - (nums[i] + nums[begin] + nums[end])==0)
                    return target;
                if (target - (nums[i] + nums[begin] + nums[end])>0){
                    begin++;
                    continue;
                }
            }
        }
        return res;
    }
}