import java.util.*;

class RandomizedSet {
    private int count = 0;
    private Random random;
    private Map<Integer, Integer> map;
    private List<Integer> set;

    public RandomizedSet() {
        map = new HashMap<>();
        set = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            set.add(val);
            map.put(val, count);
            count++;
            return true;
        } 
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.put(set.get(count - 1), index);
            set.set(index, set.get(count - 1));
            set.remove(count - 1);
            map.remove(val);
            count--;
            return true;
        }
        else return false;
    }
    
    public int getRandom() {
        int index = random.nextInt(count);
        return set.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */