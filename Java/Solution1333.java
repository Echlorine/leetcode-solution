class Solution1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        for (int[] r : restaurants) {
            if ((veganFriendly == 1 && r[2] != 1) ||
            r[3] > maxPrice ||
            r[4] > maxDistance) {
                r[1] = -1;
            }
        }
        Arrays.sort(restaurants, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        List<Integer> list = new LinkedList<>();
        for (int[] r : restaurants) {
            if (r[1] == -1) break;
            list.add(r[0]);
        }
        return list;
    }
}