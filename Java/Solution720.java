import java.util.*;

class Solution720 {
    public String longestWord(String[] words) {
        // 前缀哈希表
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        // 判断
        String res = "";
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            boolean flag = false;
            for (int j = 0; j < temp.length(); j++) {
                if (!set.contains(temp.substring(0, j + 1))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (temp.length() > res.length()) res = temp;
                else if (temp.length() == res.length()) {
                    for (int j = 0; j < temp.length(); j++) {
                        if (temp.charAt(j) < res.charAt(j)) {
                            res = temp;
                            break;
                        }
                        else if (temp.charAt(j) > res.charAt(j)) break;
                    }
                }
            }
        }
        return res;
    }
}