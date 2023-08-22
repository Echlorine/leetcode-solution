class Solution722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean isInComment = false; // 是否位于块注释中
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            if (!isInComment) sb = new StringBuilder();
            int last = 0;
            for (int i = 0; i < s.length(); i++) {
                if (isInComment && s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                    isInComment = false;
                    last = i + 2;
                    i++;
                    continue;
                }
                if (!isInComment && s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                    sb.append(s.substring(last, i));
                    isInComment = true;
                    i++;
                    continue;
                }
                if (!isInComment && s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                    sb.append(s.substring(last, i));
                    last = s.length();
                    break;
                }
            }
            if (!isInComment) {
                sb.append(s.substring(last));
                if (sb.length() > 0) res.add(sb.toString());
            }
        }
        return res;
    }
}