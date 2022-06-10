import java.util.*;

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            }
        );
        int res = 1, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] == right) continue;
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}