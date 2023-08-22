class Solution822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) continue;
            if (!set.contains(fronts[i])) res = Math.min(res, fronts[i]);
            if (!set.contains(backs[i])) res = Math.min(res, backs[i]);
        }
        return res > 2000 ? 0 : res;
    }
}