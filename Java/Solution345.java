import java.util.*;

class Solution345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>() {{
            add('a');
            add('A');
            add('e');
            add('E');
            add('i');
            add('I');
            add('o');
            add('O');
            add('u');
            add('U');
        }};
        char[] sarr = s.toCharArray();
        int left = 0, right = sarr.length - 1;
        while (left < right) {
            if (!set.contains(sarr[left])) {
                left++;
                continue;
            }
            if (!set.contains(sarr[right])) {
                right--;
                continue;
            }
            char temp = sarr[left];
            sarr[left] = sarr[right];
            sarr[right] = temp;
            left++;
            right--;
        }
        return new String(sarr);
    }
}