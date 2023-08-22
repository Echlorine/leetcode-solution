class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; Math.pow(x, i) <= bound; i++) {
            for (int j = 0; Math.pow(y, j) <= bound; j++) {
                int t = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (t > bound) break;
                set.add(t);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return set.stream().toList();
    }
}