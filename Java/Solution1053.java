class Solution1053 {
    public int[] prevPermOpt1(int[] arr) {
        // 找到最后一个升序位置对应的数，与它之后的 仅次于它的 数交换
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                int j = arr.length - 1;
                while (arr[j] >= arr[i - 1] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int t = arr[i - 1];
                arr[i - 1] = arr[j];
                arr[j] = t;
                break;
            }
        }
        return arr;
    }
}