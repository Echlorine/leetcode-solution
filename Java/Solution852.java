class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) left = mid;
            else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) right = mid;
        }
        return -1;
    }
}