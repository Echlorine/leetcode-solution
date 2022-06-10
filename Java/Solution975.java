import java.util.*;

class Solution975 {
    public int oddEvenJumps(int[] arr) {
        int[] nextodd = new int[arr.length]; // 每一个元素的奇跳位置
        int[] nexteven = new int[arr.length]; // 每一个元素的偶跳位置
        Deque<Integer> nextindex = new ArrayDeque<>();
        int[][] narr = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            nextodd[i] = -1; // 初始化记录位置数组
            nexteven[i] = -1; // 初始化记录位置数组
            narr[i][0] = i;
            narr[i][1] = arr[i];
        }
        Arrays.sort(
            narr,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
                }
            }
        );
        for (int i = 0; i < arr.length; i++) {
            // 处理递减栈
            while (!nextindex.isEmpty() && nextindex.peekLast() < narr[i][0])
                nextodd[nextindex.removeLast()] = narr[i][0];
            nextindex.addLast(narr[i][0]);
        }
        Arrays.sort(
            narr,
            new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return b[1] == a[1] ? a[0] - b[0] : b[1] - a[1];
                }
            }
        );
        nextindex.clear();
        for (int i = 0; i < arr.length; i++) {
            // 处理递减栈
            while (!nextindex.isEmpty() && nextindex.peekLast() < narr[i][0])
                nexteven[nextindex.removeLast()] = narr[i][0];
            nextindex.addLast(narr[i][0]); // 当前元素入栈
        }
        // dp
        boolean[][] dp = new boolean[arr.length][2]; // dp[i][1]表示从i可以奇跳末尾，dp[i][0]表示从i可以偶跳到末尾
        int n = arr.length - 1; // 最后一个位置
        // 边界
        dp[n][0] = true; dp[n][1] = true;
        int res = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nextodd[i] != -1) dp[i][1] = dp[nextodd[i]][0];
            if (nexteven[i] != -1) dp[i][0] = dp[nexteven[i]][1];
            if (dp[i][1]) res++;
        }
        return res;
    }
}