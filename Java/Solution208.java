import java.util.*;

class Trie {

    private Set<String> prefix;
    private List<String> all;

    public Trie() {
        prefix = new HashSet<>();
        all = new ArrayList<>();
    }
    
    public void insert(String word) {
        all.add(word);
        genprefix(word);
    }
    
    public boolean search(String word) {
        if (all.contains(word)) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        if (this.prefix.contains(prefix)) return true;
        return false;
    }

    private void genprefix(String word) {
        for (int i = 1; i <= word.length(); i++)
            prefix.add(word.substring(0, 0 + i));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */