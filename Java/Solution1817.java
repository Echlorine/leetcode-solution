class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (!map.containsKey(logs[i][0]))
                map.put(logs[i][0], new HashSet<>());
        }
        for (int i = 0; i < logs.length; i++) {
            map.get(logs[i][0]).add(logs[i][1]);
        }
        int[] res = new int[k];
        for (Integer i : map.keySet()) {
            int length = map.get(i).size();
            if (length <= k) res[length - 1]++;
        }
        return res;
    }
}