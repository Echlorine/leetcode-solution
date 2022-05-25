import java.util.*;

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(
            points,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[1] > b[1]) return 1;
                    else if (a[1] < b[1]) return -1;
                    else return 0;
                }
            }
        );
        int res = 0, i = 0;
        while (i < points.length) {
            int border = points[i][1];
            int j = i;
            while(j < points.length && points[j][0] <= border) {
                j++;
            }
            i = j;
            res++;
        }
        return res;
    }
}