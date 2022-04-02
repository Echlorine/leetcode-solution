public class quicksort {
    public static void main(String[] args) {
        int[] nums = {0, 98 ,0};
        int begin = 0, end = nums.length - 1;
        sort(nums, begin, end);
        for (int i : nums){
            System.out.println(i);
        }
    }

    public static void sort(int[] nums, int begin, int end) {
        int j = 0;
        if (begin < end){
            j = partion(nums, begin, end);
            sort(nums, begin, j - 1);
            sort(nums, j + 1, end);
        }
    }

    public static int partion(int[] nums, int begin, int end) {
        int s = begin, e = end + 1;
        int k = nums[s], temp = 0;
        while (s < e){
            s++;
            while (nums[s] < k && s < end) s++;
            e--;
            while (nums[e] > k) e--;
            if (s < e) {
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
