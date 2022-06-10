import java.util.*;

class Solution1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (v1, v2) -> v1[0] - v2[0]);
        Arrays.sort(slots2, (v1, v2) -> v1[0] - v2[0]);
        int p1 = 0, p2 = 0;
        while (p1 < slots1.length && p2 < slots2.length) {
            // 判断当前区间有没有重合
            if (slots1[p1][1] <= slots2[p2][0]) p1++;
            else if (slots2[p2][1] <= slots1[p1][0]) p2++;
            else {
                int start = Math.max(slots1[p1][0], slots2[p2][0]);
                int dur = Math.min(slots1[p1][1], slots2[p2][1]) - start;
                if (dur >= duration) {
                    res.add(start);
                    res.add(start + duration);
                    break;
                }
                if (slots1[p1][1] >= slots2[p2][1]) {
                    p2++;
                }
                else {
                    p1++;
                }
            }
        }
        return res;
    }
}