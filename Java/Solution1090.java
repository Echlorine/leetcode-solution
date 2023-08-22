class Solution1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        quickSort(values, 0, values.length - 1, labels);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < values.length && j <= numWanted; i++, j++) {
            if (j >= numWanted) break;
            int n = map.getOrDefault(labels[i], 0);
            if (n + 1 <= useLimit) {
                res += values[i];
                map.put(labels[i], n + 1);
            } else {
                j--;
            }
        }
        return res;
    }
    
    public void quickSort(int[] values, int left, int right, int[] labels) {
        if (left < right) {
            int t = partition(values, left, right, labels);
            quickSort(values, left, t - 1, labels);
            quickSort(values, t + 1, right, labels);
        }
    }
    
    public int partition(int[] values, int i, int j, int[] labels) {
        int pivot = i;
        while (i < j) {
            while (i < j && values[j] <= values[pivot]) j--;
            while (i < j && values[i] >= values[pivot]) i++;
            if (i < j) swap(values, i, j, labels);
        }
        swap(values, j, pivot, labels);
        return j;
    }
    
    public void swap(int[] values, int i, int j, int[] labels) {
        if (i == j) return;
        int t = values[i];
        values[i] = values[j];
        values[j] = t;
        t = labels[i];
        labels[i] = labels[j];
        labels[j] = t;
    }
}