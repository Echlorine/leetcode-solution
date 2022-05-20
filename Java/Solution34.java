class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int begin = 0, end = nums.length - 1;
        int index = 0;
        while (begin < end){
            index = (begin + end) / 2;
            if (target == nums[index]) {
                res[0] = index;
                begin = index;
                end = index;
                break;
            }
            if (target > nums[index]) begin = index + 1;
            if (target < nums[index]) end = index - 1;
        }
        if (res[0] == -1) return res;
        while (begin >= 0 && nums[begin] == target) begin--;
        while (end < nums.length && nums[end] == target) end++;
        res[0] = begin + 1;
        res[1] = end - 1;
        return res;
    }
}