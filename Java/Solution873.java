import java.util.*;

class Solution873 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>(); // 记录每一个以该结点结尾的最大长度
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int index = map.getOrDefault(arr[i] - arr[j], -1);
                if (index != -1 && index < j) {
                    int cand = dp.getOrDefault(index * arr.length + j, 2) + 1;
                    dp.put(j * arr.length + i, cand);
                    res = Math.max(res, cand);
                }
            }
        }
        return res >= 3 ? res : 0;
    }
}