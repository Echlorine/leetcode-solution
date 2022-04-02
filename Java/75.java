class Solution75 {
    public void sortColors(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public void quicksort(int[] nums, int begin, int end){
        if (begin < end){
            int j = partion(nums, begin, end);
            quicksort(nums, begin, j - 1);
            quicksort(nums, j + 1, end);
        }
    }

    public int partion(int[] nums, int begin, int end){
        int s = begin, e = end + 1;
        int k = nums[begin], temp = 0;
        while (s < e){
            s++;
            while (s < nums.length && nums[s] < k) s++;
            e--;
            while (nums[e] > k) e--;
            if (s < e){
                temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
            }
        }
        temp = nums[e];
        nums[e] = nums[begin];
        nums[begin] = temp;
        return e;
    }
}