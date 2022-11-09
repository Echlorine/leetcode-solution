import java.util.ArrayDeque;
import java.util.Deque;

class Solution1475 {
    public int[] finalPrices(int[] prices) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peekLast()[1] >= prices[i]) {
                int index = stack.peekLast()[0];
                int price = stack.pollLast()[1];
                res[index] = price - prices[i];
            }
            stack.offerLast(new int[] {i, prices[i]});
        }
        while (!stack.isEmpty()) {
            res[stack.peekLast()[0]] = stack.pollLast()[1];
        }
        return res;
    }
}