import java.util.*;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxlen = 0;
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> word = new HashSet<>();
        // 构建hash集合，并记录字典中最大单词的长度
        for (int i = 0; i < wordDict.size(); i++){
            word.add(wordDict.get(i));
            maxlen = Math.max(wordDict.get(i).length(), maxlen);
        }
        dp[0] = true; // 边界条件
        for (int i = 1; i <= s.length(); i++) // 注意i是字串的长度
            for (int j = i - 1; j >= 0; j--){ // j是字串的分隔位置
                if (i - j <= maxlen) {
                    dp[i] = dp[j] && word.contains(s.substring(j, i));
                    if (dp[i] == true) break;
                }
                else break;
            }
        return dp[s.length()];
    }
}