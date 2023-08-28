class FirstUnique {

    private Set<Integer> queue;

    private Set<Integer> set;

    public FirstUnique(int[] nums) {
        queue = new LinkedHashSet<>();
        set = new HashSet<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if (!queue.isEmpty()) {
            return queue.iterator().next();
        }
        return -1;
    }
    
    public void add(int value) {
        if (set.contains(value)) {
            queue.remove(value);
        } else {
            queue.add(value);
        }
        set.add(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */