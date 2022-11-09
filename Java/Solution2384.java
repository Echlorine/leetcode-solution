import java.util.ArrayList;
import java.util.List;

class Solution2384 {
    public String largestPalindromic(String num) {
        int[] counts = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int t = num.charAt(i) - '0';
            counts[t]++;
        }
        // maxOdd，出现次数为奇数的最大数字
        List<Integer> list = new ArrayList<Integer>();
        int maxOdd = -1;
        for (int i = 0; i < 10; i++) {
            if (counts[i] > 1) {
                list.add(i);
                if (counts[i] % 2 != 0) {
                    maxOdd = i;
                }
            } else if (counts[i] == 1) {
                maxOdd = i;
            }
        }
        // 生成最大回文串
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            int temp = list.get(i);
            if (temp == 0 && list.size() == 1) {
                continue;
            }
            for (int j = counts[temp] / 2; j > 0; j--) {
                sb.append(temp);
            }
        }
        String res = maxOdd != -1 ? sb.toString() + maxOdd + sb.reverse().toString() : sb.toString() + sb.reverse().toString();
        return res.equals("") ? "0" : res;
    }
}