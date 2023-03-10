class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyTime.length; i++) {
            int time = cal_time(keyTime[i]);
            List<Integer> t = map.getOrDefault(keyName[i], new ArrayList<>());
            t.add(time);
            map.put(keyName[i],t);
        }
        for (String str : map.keySet()) {
            List<Integer> t = map.get(str);
            Collections.sort(t);
            for (int i = 0; i < t.size() - 2; i++) {
                int last = t.get(i);
                if (t.get(i + 2) - last <= 60) {
                    res.add(str);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public int cal_time(String time) {
        int hour = (time.charAt(0) - '0') * 10 + time.charAt(1) - '0';
        int min = (time.charAt(3) - '0') * 10 + time.charAt(4) - '0';
        return hour * 60 + min;
    }
}