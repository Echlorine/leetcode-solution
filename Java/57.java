import java.util.*;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
         * 直接遍历合并区间
         */
        if (intervals.length == 0) return new int[][] {newInterval}; // 原始区间长度为0
        int left = 0, right = 0;
        List<int[]> res = new LinkedList<>();
        boolean leftflag = false, rightflag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!leftflag && !rightflag) { // 还没确定左区间
                if (intervals[i][1] < newInterval[0]) {
                    res.add(intervals[i]);
                    if (i == intervals.length - 1) res.add(newInterval);
                }
                else {
                    if (intervals[i][0] <= newInterval[0]) left = intervals[i][0];
                    else left = newInterval[0];
                    i--;
                    leftflag = true;
                }
            }
            else if (leftflag && !rightflag) { // 已经确定左区间但没确定右区间
                if (i == 0 && newInterval[1] < intervals[i][0]) {
                    right = newInterval[1];
                    res.add(new int[] {left, right});
                    i--;
                    rightflag = true;
                }
                if (i > 0 && intervals[i][0] > newInterval[1] && intervals[i - 1][0] <= newInterval[1]) {
                    if (intervals[i - 1][1] > newInterval[1]) right = intervals[i - 1][1];
                    else right = newInterval[1];
                    res.add(new int[] {left, right});
                    i--;
                    rightflag = true;
                }
                if (i == intervals.length - 1 && intervals[i][0] <= newInterval[1]) {
                    if (intervals[i][1] > newInterval[1]) right = intervals[i][1];
                    else right = newInterval[1];
                    res.add(new int[] {left, right});
                    rightflag = true;
                }
            }
            else if (leftflag && rightflag) {
                res.add(intervals[i]);
            }
        }
        int[][] a = new int[res.size()][];
        return res.toArray(a);
    }
}