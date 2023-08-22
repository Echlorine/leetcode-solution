class Solution833 {
    private String s;

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        this.s = s;
        quickSort(indices, 0, indices.length - 1, sources, targets);
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < indices.length; i++) {
            if (i > 0 && indices[i] == indices[i - 1]) continue;
            int len = sources[i].length();
            if (indices[i] + len > s.length()) continue;
            if (indices[i] > last) sb.append(s.substring(last, indices[i]));
            last = indices[i] + len;
            if (s.substring(indices[i], indices[i] + len).equals(sources[i])) {
                sb.append(targets[i]);
            } else {
                sb.append(s.substring(indices[i], indices[i] + len));
            }
        }
        if (last < s.length()) sb.append(s.substring(last));
        return sb.toString();
    }

    public void quickSort(int[] nums, int begin, int end, String[] sources, String[] targets) {
        // 递归快速排序
        int j = 0;
        if (begin < end){
            j = partition(nums, begin, end, sources, targets);
            quickSort(nums, begin, j - 1, sources, targets);
            quickSort(nums, j + 1, end, sources, targets);
        }
    }

    public int partition(int[] nums, int l, int r, String[] sources, String[] targets) {
        // 待确定位置的元素
        int pivot = l;
        while (l < r) {
            while (l < r && compare(nums, pivot, r, sources, targets)) {
                r--;
            }
            while (l < r && compare(nums, l, pivot, sources, targets)) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r, sources, targets);
            }
        }
        swap(nums, r, pivot, sources, targets);
        return r;
    }

    public boolean compare(int[] nums, int l, int r, String[] sources, String[] targets) {
        // 判断 l < r ?
        if (nums[l] != nums[r]) return nums[l] < nums[r];
        //
        if (nums[l] + sources[l].length() <= s.length() &&
                s.substring(nums[l], nums[l] + sources[l].length()).equals(sources[l])) {
            return true;
        }
        if (nums[r] + sources[r].length() <= s.length() &&
                s.substring(nums[r], nums[r] + sources[r].length()).equals(sources[r])) {
            return false;
        }
        return true;
    }

    public void swap(int[] nums, int l, int r, String[] sources, String[] targets) {
        if (l == r) return;
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
        String str = sources[l];
        sources[l] = sources[r];
        sources[r] = str;
        str = targets[l];
        targets[l] = targets[r];
        targets[r] = str;
    }
}