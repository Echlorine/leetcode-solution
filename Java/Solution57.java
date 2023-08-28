import java.util.*;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
            if (intervals[i][0] <= newInterval[0] && (i + 1 == intervals.length || newInterval[0] < intervals[i + 1][0])) {
                index = i;
                list.add(newInterval);
            }
        }
        if (index == -1) {
            list.add(0, newInterval);
            index = 0;
        }
        int lLast = list.get(index)[0], rLast = list.get(index)[1];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < index) res.add(list.get(i));
            else {
                if (rLast >= list.get(i)[0]) rLast = Math.max(rLast, list.get(i)[1]);
                else {
                    res.add(new int[] {lLast, rLast});
                    lLast = list.get(i)[0];
                    rLast = list.get(i)[1];
                }
            }
        }
        res.add(new int[] {lLast, rLast});
        int[][] r = new int[res.size()][2];
        res.toArray(r);
        return r;
    }
}