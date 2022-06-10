class Solution1523 {
    public int countOdds(int low, int high) {
        int len = high - low + 1;
        if (len % 2 == 1 && low % 2 == 1) return len / 2 + 1;
        else return len / 2;
    }
}