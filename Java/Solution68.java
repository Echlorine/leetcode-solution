import java.util.*;

class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        boolean flag = true; // 标记这是某一行的开头
        int len = 0, index = 0;
        for (int i = 0; i < words.length; i++) {
            if (flag) {
                len += words[i].length();
                flag = false;
            }
            else {
                if (len + words[i].length() + 1 > maxWidth) {
                    res.add(getline(words, index, i, maxWidth, len - (i - index - 1), false));
                    flag = true;
                    len = 0;
                    index = i;
                    i--;
                }
                else {
                    len += words[i].length() + 1;
                }
            }
        }
        res.add(getline(words, index, words.length, maxWidth, 0, true));
        return res;
    }

    public String getline(String[] words, int start, int end, int maxWidth, int len, boolean flag) {
        StringBuilder sb = new StringBuilder();
        int num = end - start;
        if (num == 1 || flag) {
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                if (sb.length() == maxWidth) break;
                sb.append(" ");
            }
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(" ");
            }
        }
        else {
            int count = maxWidth - len; // 应该填充的空格数
            int baseblack = count / (num - 1); // 每个间隔应该填充的最少空格数
            int diff = count % (num - 1); // 前diff个间隔应该多填充一个间隔
            int index = 0;
            while (index < diff) {
                sb.append(words[start + index]);
                for (int i = 0; i <= baseblack; i++) {
                    sb.append(" ");
                }
                index++;
            }
            while (index < num) {
                sb.append(words[start + index]);
                for (int i = 0; i < baseblack && sb.length() < maxWidth; i++) {
                    sb.append(" ");
                }
                index++;
            }
        }
        return sb.toString();
    }
}