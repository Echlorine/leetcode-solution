import java.util.*;

class Solution1456 {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>() {{
            add('a'); add('e'); add('i'); add('o'); add('u');
            add('A'); add('E'); add('I'); add('O'); add('U');
        }};
        int sum = 0, res = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) sum++;
        }
        res = sum;
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) sum++;
            if (set.contains(s.charAt(i - k))) sum--;
            res = Math.max(res, sum);
        }
        return res;
    }
}