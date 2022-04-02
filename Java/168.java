import java.util.*;

class Solution168 {
    public static String convertToTitle(int columnNumber) {
        // 问题本质: 十进制与26进制的转化
        // 但是该进制没有 0，与普通的还不一样
        int radix = 26; // 进制底为26
        int num = columnNumber;
        List<Integer> ans = new ArrayList<>();
        int temp = 0;
        String s = "";
        Map<Integer, String> column = new HashMap<Integer, String>() {{
            put(1, "A"); put(2, "B"); put(3, "C"); put(4, "D"); put(5, "E"); put(6, "F"); put(7, "G");
            put(8, "H"); put(9, "I"); put(10, "J"); put(11, "K"); put(12, "L"); put(13, "M"); put(14, "N");
            put(15, "O"); put(16, "P"); put(17, "Q"); put(18, "R"); put(19, "S"); put(20, "T");
            put(21, "U"); put(22, "V"); put(23, "W"); put(24, "X"); put(25, "Y"); put(26, "Z");
        }};
        // 与求十进制的每一位的数大小类似，我们求26进制的每一位数是多少
        while(num >= radix){
            temp = num % radix;
            if (temp == 0) {temp = radix;}
            num = (num - temp) /radix;
            ans.add(temp);
        }
        if (num != 0) ans.add(num);
        int len = ans.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++){
            res.add(0);
        }
        for (int i = 0; i < len; i++){
            res.set(len - 1 - i, ans.get(i));
        }
        for (int r : res)
            s += column.get(r);
    return s;
    }
}

// 2147483647
// "FXSHRXW"
// 6 * 26 ** 6 + 24 * 26 ** 5 + 19 * 26 ** 4 + 8 * 26 ** 3 + 18 * 26 ** 2 + 24 * 26 ** 1 + 23 * 26 ** 0
