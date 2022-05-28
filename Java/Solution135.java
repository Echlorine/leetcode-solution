class Solution135 {
    public int candy(int[] ratings) {
        int res = 1, pre = 1;
        int inum = 1, dnum = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dnum = 0;
                if (ratings[i] > ratings[i - 1]) pre++;
                else pre = 1;
                res += pre;
                inum = pre;
            }
            else {
                dnum++;
                if (inum == dnum) {
                    dnum++;
                }
                res += dnum;
                pre = 1;
            }
        }
        return res;
    }
}