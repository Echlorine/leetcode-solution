class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int begin = i;
                while (i < s.length() && s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(begin + 1, i);
                sb.append(map.getOrDefault(key, "?"));
            } else if (s.charAt(i) == ')') continue;
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}