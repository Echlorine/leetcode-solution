import java.util.*;

class Solution227 {
    public int calculate(String s) {
        s = s + " ";
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        int res = 0, index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                if (index < i) {
                    int temp = Integer.valueOf(s.substring(index, i));
                    index = i + 1;
                    if (!ops.isEmpty() && ops.peekLast() == '*') {
                        ops.removeLast();
                        temp *= nums.removeLast();
                    }
                    else if (!ops.isEmpty() && ops.peekLast() == '/') {
                        ops.removeLast();
                        temp = nums.removeLast() / temp;
                    }
                    nums.addLast(temp);
                    if (s.charAt(i) != ' ') ops.addLast(s.charAt(i));
                }
                else {
                    if (s.charAt(i) != ' ') ops.addLast(s.charAt(i));
                    index = i + 1;
                }
            }
        }
        while (!ops.isEmpty()) {
            if (ops.removeLast() == '-') res -= nums.removeLast();
            else res += nums.removeLast();
        }
        return res += nums.removeLast();
    }
}