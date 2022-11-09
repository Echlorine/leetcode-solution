class Solution1694 {
    public String reformatNumber(String number) {
        String[] numbers = number.split("-");
        String num = ""; number="";
        for (String temp : numbers) {
            if (temp.length() == 0) continue;
            String [] temps = temp.split(" ");
            for (String t : temps) {
                if (t.length() == 0) continue;
                num += t;
            }
        }
        int len = num.length();
        for (int i = 0; i < len; i += 3) {
            if (i < len - 4) number += num.substring(i, i + 3) + "-";
            else if (i == len - 4) {
                number += num.substring(i, i + 2) + "-" + num.substring(i + 2, len);
                break;
            }
            else if (i == len - 3) {
                number += num.substring(i, len);
                break;
            }
            else {
                number += num.substring(i, len);
                break;
            }
        }
        return number;
    }
}