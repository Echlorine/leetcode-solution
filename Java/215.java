class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        // 这一部分是利用快排实现的
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
        // 分划操作
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

    public int topKLargest(int[] nums, int k) {
        // 这一部分是利用堆排序实现的
        // 建立初始堆
        for (int i = nums.length / 2; i >= 1; i--)
            restore(nums, i, nums.length);
        // 进行堆排序，找到第K个最大即可
        int border = nums.length - k > 2 ? nums.length - k : 2;
        for (int i = nums.length; i >= border; i--) {
            int temp = nums[0];
            nums[0] = nums[i - 1];
            nums[i - 1] = temp;
            restore(nums, 1, i - 1);
        }
        return nums[nums.length - k];
    }
    
    public void restore(int[] nums, int root, int len) {
        // 利用最大堆进行排序，需要注意数组的下标与堆结点下标的之间相差 1
        int p = root; // 堆的根结点
        int m = 0, temp = 0;
        while (p <= len / 2) {
            // 比较当前结点的左右孩子的大小
            if (2 * p + 1 <= len && nums[2 * p - 1] < nums[2 * p])
                m = 2 * p +1;
            else m = 2 * p;
            // 判断孩子结点与父节点是否需要交换位置
            if (nums[m - 1] > nums[p - 1]) {
                temp = nums[m - 1];
                nums[m - 1] = nums[p - 1];
                nums[p - 1] = temp;
                p = m;
            }
            else break;
        }
    }
}