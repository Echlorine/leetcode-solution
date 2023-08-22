class Solution2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        // 时间转化为整数
        int[] e1 = genTime(event1), e2 = genTime(event2);
        // 考虑没有交集的情况
        if (e1[1] < e2[0] || e2[1] < e1[0]) {
            return false;
        }
        return true;
    }

    public int[] genTime(String[] event) {
        int[] events = new int[event.length];
        for (int i = 0; i < event.length; i++) {
            String[] times = event[i].split(":");
            int hour = str2Int(times[0]);
            int minute = str2Int(times[1]);
            events[i] = hour * 60 + minute;
        }
        return events;
    }

    public int str2Int(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res *= 10;
            res += str.charAt(i) - '0';
        }
        return res;
    }
}