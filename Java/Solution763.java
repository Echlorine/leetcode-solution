import java.util.*;

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] indix = new int[26];
        Arrays.fill(indix, -1);
        for (int i = 0; i < s.length(); i++) {
            indix[s.charAt(i) - 'a'] = i;
        }
        int index = 0;
        int start = 0, end = 0;
        List<Integer> res = new LinkedList<>();
        while (index < s.length()) {
            end = Math.max(end, indix[s.charAt(index) - 'a']);
            if (index == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
            index++;
        }
        return res;
    }
}