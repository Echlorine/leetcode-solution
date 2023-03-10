class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            int value = items1[i][0], weight = items1[i][1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        for (int i = 0; i < items2.length; i++) {
            int value = items2[i][0], weight = items2[i][1];
            map.put(value, map.getOrDefault(value, 0) + weight);
        }
        for (Integer key : map.keySet()) {
            res.add(new ArrayList<>() {{
                add(key);
                add(map.get(key));
            }});
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a1,List<Integer> a2) {
                return a1.get(0) - a2.get(0);
            }
        });
        return res;
    }
}