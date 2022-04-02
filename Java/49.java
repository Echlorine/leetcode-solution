import java.util.*;

class Solution49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int[] hashs = new int[strs.length];
        int[] hashs2 = new int[strs.length];
        for (int i = 0; i < strs.length; i++){
            hashs[i] = gethash(strs[i]);
            hashs2[i] = gethash2(strs[i]);
        }
        for (int i : hashs)
            System.out.println(i);
        // 对hash值进行快速排序，同时保证hash与原字符串数组队列
        QuickSort(hashs, strs, 0, strs.length - 1);
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

    public static int gethash(String str){
        int strhash = 0;
        for (int i = 0; i < str.length(); i++)
            strhash ^= str.charAt(i);
        return strhash;
    }

    public static int gethash2(String str){
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

    public static void QuickSort(int[] shash, String[] strs, int s, int e){
        int j = 0;
        if (s < e) {
            j = partion(shash, strs, s, e);
            QuickSort(shash, strs, s, j - 1);
            QuickSort(shash, strs, j + 1, e);
        }
    }

    public static int partion(int[] shash, String[] strs, int begin, int end){
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
}