class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int[] hash = new int[fruits.length];
        int num = 0, res = 0;
        while(left < fruits.length) {
            while (right < fruits.length && num <= 2) {
                if (num <= 2) res = Math.max(res, right - left);
                int t = fruits[right++];
                if (hash[t] == 0) num++;
                hash[t]++;
            }
            if (num <= 2) res = Math.max(res, right - left);
            int temp = fruits[left++];
            if (--hash[temp] == 0) num--;
        }
        return res;
    }
}