import java.util.*;

class Solution253 {
    public static int minMeetingRooms(int[][] intervals) {
        // 特例
        if (intervals.length == 0) {
            return 0;
        }
        // 按照会议开始时间对会议排序，利用接口与lambda表达式
        Arrays.sort(
            intervals,
            new Comparator<int[]>() {
                public int compare(final int[] a, final int[] b) {
                    return a[0] - b[0];
                }
            }
        );
        // 优先队列，并实现了Comparator接口，按照数值大小排序
        PriorityQueue<Integer> rooms =
        new PriorityQueue<Integer>(
            intervals.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            }
        );
        // 添加第一个会议的结束时间
        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= rooms.peek())
                rooms.poll(); // 不冲突，删除结束时间最早的会议
            rooms.add(intervals[i][1]); // 给需要的会议安排会议室
        }
        return rooms.size();
    }
}