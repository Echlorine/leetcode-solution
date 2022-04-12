import java.util.*;

class Solution804 {
    String[] map = new String[] {".-","-...","-.-.","-..",".","..-.","--.",
                                "....","..",".---","-.-",".-..","--","-.",
                                "---",".--.","--.-",".-.","...","-",
                                "..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>();
        for (String str : words) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < str.length(); i++) 
                temp.append(map[str.charAt(i) - 97]);
            res.add(temp.toString());
        }
        return res.size();
    }
}