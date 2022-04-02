class Solution31 {
    public static void nextPermutation(int[] nums) {
        int index = nums.length - 1, index2 = 0, temp = 1;
        int begin = 0, end = nums.length - 1;
        // 找到中间最大值，并记录下标
        for(int i = nums.length - 1; i >= 0; i--)
            if ( i != 0 && nums[i - 1] < nums[i]) {index = i; temp = 0; break;}
        // 从右边找大值
        if (index != nums.length - 1 || (index == nums.length - 1 && temp == 0)){
            for(int i = nums.length - 1; i >= 0; i--)
                if (nums[i] > nums[index - 1]) {index2 = i; break;}
            // 交换
            temp = nums[index - 1];
            nums[index - 1] = nums[index2];
            nums[index2] = temp;
            begin = index;
        }
        // 排序
        for (int i = 0; i < nums.length; i++){
            if (begin >= end) break;
            temp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = temp;
            begin++;
            end--;
        }
        for (int a : nums)
            System.out.println(a);
    }
}