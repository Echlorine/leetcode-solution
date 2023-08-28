class Solution1426 {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        int res = 0;
        for (int a : arr) {
            if (set.contains(a + 1)) res++;
        }
        return res;
    }
}