class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            for (int i = 0; i < piece.length; i++) {
                if (hashMap.getOrDefault(piece[i], -1) == -1) return false;
                if (i == 0) continue;
                else if (hashMap.get(piece[i]) - hashMap.get(piece[i - 1]) == 1) continue;
                return false;
            }
        }
        return true;
    }
}