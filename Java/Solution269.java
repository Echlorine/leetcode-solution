class Solution269 {
    private Set<Integer> set = new HashSet<>();
    private int[][] adjacencyGrid = new int[26][26];
    private int[] inValues = new int[26];
    private boolean flag = false;;

    public String alienOrder(String[] words) {
        if (words.length == 1) getGraph(words[0], "");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 构建邻接矩阵
                getGraph(words[i], words[j]);
                if (flag) return ""; // 有特例直接返回
            }
        }
        // 拓扑排序
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inValues.length; i++) {
            if (set.contains(i) && inValues[i] == 0) {
                queue.offer(i);
                sb.append((char) (i + 'a'));
            }
        }
        int num = 0;
        while (!queue.isEmpty()) {
            num++;
            int t = queue.poll();
            for (int i = 0; i < 26; i++) {
                if (adjacencyGrid[t][i] == 1) {
                    inValues[i]--;
                    if (inValues[i] == 0) {
                        queue.offer(i);
                        sb.append((char) (i + 'a'));
                    }
                }
            }
        }
        if (set.size() > num) return "";
        return sb.toString();
    }

    public void getGraph(String s1, String s2) {
        int l = Math.min(s1.length(), s2.length());
        int r = Math.max(s1.length(), s2.length());
        for (int i = 0; i < r; i++) {
            if (i < s1.length()) set.add(s1.charAt(i) - 'a');
            if (i < s2.length()) set.add(s2.charAt(i) - 'a');
        }
        for (int i = 0; i < l; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (adjacencyGrid[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] != 1) {
                adjacencyGrid[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
                inValues[s2.charAt(i) - 'a']++;
            }
            return;
        }
        if (s1.length() > s2.length()) {
            flag = true;
            return;
        }
        String sub = s1.length() < s2.length() ? s2.substring(l, r) : s1.substring(l, r);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (adjacencyGrid[s1.charAt(i) - 'a'][sub.charAt(j) - 'a'] != 1) {
                    adjacencyGrid[s1.charAt(i) - 'a'][sub.charAt(j) - 'a'] = 1;
                    inValues[sub.charAt(j) - 'a']++;
                }
            }
        }
    }
}