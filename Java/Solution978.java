class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        int flag = -1; // 1 代表前一个是 >, 0 代表前一个是 <
        int left = 0, right = 0, res = 0;
        // 找起点
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] < arr[i + 1]) flag = 0;
                else flag = 1;
                left = i;
                right = i + 1;
                break;
            }
        }
        if (flag == -1) return 1;
        while (right < arr.length - 1) {
            if (flag == 1 && arr[right] < arr[right + 1]) flag ^= 1; // 修改 flag 标记
            else if (flag == 0 && arr[right] > arr[right + 1]) flag ^= 1;
            else {
                res = Math.max(res, right - left + 1);
                flag = -1;
                for (int i = right; i < arr.length - 1; i++) {
                    if (arr[i] != arr[i + 1]) {
                        if (arr[i] < arr[i + 1]) flag = 0;
                        else flag = 1;
                        left = i;
                        right = i + 1;
                        break;
                    }
                }
                if (flag == -1) return res;
                right--;
            }
            right++;
        }
        return Math.max(res, right - left + 1);
    }
}