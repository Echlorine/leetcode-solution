import java.util.*;

class Solution402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            char temp = num.charAt(i);
            while (count < k && !stack.isEmpty() && stack.peekLast() > temp) {
                count++;
                stack.removeLast();
            }
            stack.addLast(temp);
        }
        while (count < k) {
            count++;
            stack.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.peek() == '0' && sb.length() == 0) stack.remove();
            else sb.append(stack.remove());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}