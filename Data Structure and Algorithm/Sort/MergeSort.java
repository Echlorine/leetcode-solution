public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {13, 23, 42, 88, 5, 24, 16, 5};
        int []temp = new int[nums.length]; //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergesort(nums, 0, nums.length - 1, temp);
        for (int i : nums)
            System.out.println(i);
    }

    public static void mergesort(int[] nums, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            mergesort(nums, left, mid, temp); //左边归并排序，使得左子序列有序
            mergesort(nums, mid + 1, right, temp); //右边归并排序，使得右子序列有序
            merge(nums, left, mid, right, temp); //将两个有序子数组合并操作
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left; //左序列起始位置
        int j = mid + 1; //右序列起始位置
        int t = 0; //临时数组指针
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                temp[t++] = nums[i++];
            else
                temp[t++] = nums[j++];
        }
        //将左边剩余元素填充进temp中
        while (i <= mid)
            temp[t++] = nums[i++];
        //将右序列剩余元素填充进temp中
        while (j <= right)
            temp[t++] = nums[j++];
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right)
            nums[left++] = temp[t++];
    }
}
