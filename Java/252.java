class Solution252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        quicksort(intervals, 0, intervals.length - 1);
        for (int i = 0; i < intervals.length; i++)
            if (i != intervals.length - 1 && intervals[i][1] > intervals[i + 1][0])
                return false;
        return true;
    }

    public static void quicksort(int[][] intervals, int st, int en){
        int j = 0;
        if (st < en){
            j = partion(intervals, st, en);
            quicksort(intervals, st, j - 1);
            quicksort(intervals, j + 1, en);
        }
    }

    public static int partion(int[][] intervals, int begin, int end){
        int s = begin, e = end + 1;
        int[] temp = new int[2];
        while (s < e){
            s++;
            while (s <= end && intervals[s][0] < intervals[begin][0]) s++;
            e--;
            while (intervals[e][0] > intervals[begin][0]) e--;
            if (s < e){
                temp = intervals[s];
                intervals[s] = intervals[e];
                intervals[e] = temp;
            }
        }
        // 只能让e与begin互换，因为s一定比begin大
        temp = intervals[e];
        intervals[e] = intervals[begin];
        intervals[begin] = temp;
        return e;
    }
}