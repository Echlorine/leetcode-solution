class Solution1016 {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String n_Bin = Integer.toBinaryString(i);
            if (!s.contains(n_Bin)) return false;
        }
        return true;
    }
}