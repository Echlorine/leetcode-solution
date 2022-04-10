import java.util.*;

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i])
                s.pop();
            // 栈中只剩下比自己大的元素
            res[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i); // 将下标压入栈

        }
        return res;
    }

    public static int[] dailyTemperature(int[] temperatures) {
        // 单调栈
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int r = s.pop();
                res[r] = i - r;
            }
            s.push(i);
        }
        return res;
    }
}