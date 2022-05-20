import java.util.*;

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int[] hashs = new int[strs.length];
        for (int i = 0; i < strs.length; i++){
            // hashs[i] = gethash(strs[i]);
            hashs[i] = gethash2(strs[i]);
        }
        // 对hash值进行快速排序，同时保证hash与原字符串数组队列
        quicksort(hashs, strs, 0, strs.length - 1);
        // 主体
        int temp = hashs[0];
        ans.add(strs[0]);
        for (int i = 1; i < strs.length; i++){
            if (hashs[i] == temp) ans.add(strs[i]);
            else{
                res.add(ans);
                ans = new ArrayList<>();
                temp = hashs[i];
                ans.add(strs[i]);
            }
        }
        res.add(ans);
        return res;
    }

    public int gethash(String str){
        int strhash = 0;
        for (int i = 0; i < str.length(); i++)
            strhash ^= str.charAt(i);
        return strhash;
    }

    public int gethash2(String str){
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        int mod = (int)Math.pow(10, 9) + 7;
        int hash = 1;
        int num;
        for (int i = 0; i < str.length(); i++){
            num = str.charAt(i) - 97;
            hash = ((hash % mod) * (prime[num] % mod)) % mod;
        }
        return hash;
    }

    public void quicksort(int[] shash, String[] strs, int s, int e){
        int j = 0;
        if (s < e) {
            j = partion(shash, strs, s, e);
            quicksort(shash, strs, s, j - 1);
            quicksort(shash, strs, j + 1, e);
        }
    }

    public int partion(int[] shash, String[] strs, int begin, int end){
        int s = begin, e = end + 1, k = shash[begin];
        int itemp; String stemp;
        while (s < e){
            s++;
            while (shash[s] < k && s < end) s++;
            e--;
            while (shash[e] > k) e--;
            if (s < e) {
                itemp = shash[s]; stemp = strs[s];
                shash[s] = shash[e]; strs[s] = strs[e];
                shash[e] = itemp;  strs[e] = stemp;
            }
        }
        itemp = shash[e]; stemp = strs[e];
        shash[e] = shash[begin]; strs[e] = strs[begin];
        shash[begin] = itemp;  strs[begin] = stemp;
        return e;
    }

    public List<List<String>> hashmapgroupAnagrams(String[] strs) {
        /**
         * 利用哈希实现
         */
        HashMap<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        
        for (int i = 0; i < n; i++) {
            // 将每个字符串转字符数组
            char[] chars = strs[i].toCharArray();
            // 对字符数组按照字母顺序排序
            Arrays.sort(chars);
            // 将排序好的字符数组转成字符串
            String key = new String(chars);
            if (!map.containsKey(key))
            //若不存在，则为新的异位词语，在map中创建新的键值对
                map.put(key,  new ArrayList<>());
            // 将该字符串放在对应key的list中
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}