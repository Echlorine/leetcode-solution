class Solution33 {
    public int search(int[] nums, int target) {
        // 思路，二分查找
        int midindex = 0, len = nums.length;
        int begin = 0, end = 0;
        if (len == 1 && nums[len - 1] == target) return len - 1;
        if (len == 1 && nums[len - 1] != target) return -1;
        // 找到旋转点
        for (int i = 0; i < len - 1; i++){
            if(nums[i] > nums[i + 1]) {midindex = i; break;}
        }
        if (nums[0] <= target && target <= nums[midindex]) {begin = 0; end = midindex;}
        if (nums[midindex + 1] <= target && target <= nums[len - 1]) {begin = midindex + 1; end = len - 1;}
        if (begin == 0 &&  end == 0 && nums[0] != target) return -1;
        // 二分查找
        while (begin <= end) {
            midindex = (begin + end) / 2;
            if (nums[midindex] == target) return midindex;
            if (nums[midindex] < target) begin = midindex + 1;
            if (nums[midindex] > target) end = midindex - 1;
        }
        return -1;
    }
}

/** 
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环. 
*/