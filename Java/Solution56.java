import java.util.*;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        int begin = 0, end = intervals.length - 1;
        quicksort(intervals, begin, end);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i <= end; i++){
            if (intervals[i][0] <= intervals[i - 1][1]){
                intervals[i][1] = intervals[i - 1][1] > intervals[i][1] ? intervals[i - 1][1] : intervals[i][1];
                intervals[i][0] = intervals[i - 1][0];
                res.set(res.size() - 1, intervals[i]);
            }
            else res.add(intervals[i]);
        }
        int[][] r = new int[res.size()][2];
        res.toArray(r);
        return r;
    }

    public void quicksort(int[][] intervals, int begin, int end){
        int j = 0;
        if (begin < end) {
            j = partion(intervals, begin, end);
            quicksort(intervals, begin, j - 1);
            quicksort(intervals, j + 1, end);
        }
    }

    public int partion(int[][] intervals, int begin, int end){
        int k = intervals[begin][0];
        int[] temp = new int[2];
        int s = begin, e = end + 1;
        while (s < e){
            s++;
            while (intervals[s][0] < k && s < end) s++;
            e--;
            while (intervals[e][0] > k) e--;
            if (s < e){
                temp = intervals[s];
                intervals[s] = intervals[e];
                intervals[e] = temp;
            }
        }
        temp = intervals[e];
        intervals[e] = intervals[begin];
        intervals[begin] = temp;
        return e;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
        int lLast = intervals[0][0], rLast = intervals[0][1];
        List<int[]> list = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == lLast || rLast >= intervals[i][0]) rLast = Math.max(rLast, intervals[i][1]);
            else {
                list.add(new int[] {lLast, rLast});
                lLast = intervals[i][0];
                rLast = intervals[i][1];
            }
        }
        list.add(new int[] {lLast, rLast});
        int[][] res = new int[list.size()][2];
        list.toArray(res);
        return res;
    }
}