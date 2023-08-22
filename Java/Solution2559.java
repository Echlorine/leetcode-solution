class Solution2559 {
    private Set<Character> set = new HashSet<>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};

    public int[] vowelStrings(String[] words, int[][] queries) {
        boolean[] isVowel = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            isVowel[i] = isVowelString(words[i]);
        }
        int[] counts = new int[words.length];
        for (int i = 0; i < counts.length; i++) {
            int t = isVowel[i] ? 1 : 0;
            if (i > 0) {
                counts[i] = counts[i - 1] + t;
            } else {
                counts[i] = t;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int query1 = queries[i][0], query2 = queries[i][1];
            int r1 = query1 == 0 ? 0 : counts[query1 - 1];
            int r2 = counts[query2];
            res[i] = r2 - r1;
        }
        return res;
    }

    public boolean isVowelString(String word) {
        char first = word.charAt(0), last = word.charAt(word.length() - 1);
        return set.contains(first) && set.contains(last);
    }
}