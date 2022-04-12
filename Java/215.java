class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int s = 0, e = nums.length - 1;
        l = partion(nums, s, e);
        while (l != nums.length - k) {
            if (l < nums.length - k) {s = l + 1;}
            if (l > nums.length - k) {e = l - 1;}
            l = partion(nums, s, e);
        }
        return nums[nums.length - k];
    }

    public int partion(int[] nums, int s, int e) {
        int begin = s, end = e + 1;
        int k = nums[begin], temp = 0;
        while (begin < end) {
            begin++;
            while (begin < e && nums[begin] < k)
                begin++;
            end--;
            while (nums[end] > k)
                end--;
            if (begin < end) {
                temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
            }
        }
        temp = nums[end];
        nums[end] = nums[s];
        nums[s] = temp;
        return end;
    }
}