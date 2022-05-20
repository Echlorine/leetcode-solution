class Solution8 {
    public int myAtoi(String s) {
        char []sarray = s.toCharArray();
        int len = s.length(), flag = 0;
        boolean run=false;
        String res = "";
        int q=0;
        for (int i=0; i<len; i++){
            if (sarray[i] == ' ' && !run)
                continue;
            if (sarray[i] == '-' && !run){
                if (flag == 0)
                    {flag = -1; run = true; continue;}
                else
                    return 0;
            }
            if (sarray[i] == '+' && !run){
                if (flag == 0)
                    {flag = 1; run = true; continue;}
                else
                    return 0;
            }
            if (flag==0)
                flag = 1;
            if (sarray[i]>=48 && sarray[i] <= 57){ // 数字
                res = res + sarray[i];
                run = true;
            }
            else if (!run)
                return 0;
            else
                break;
        }
        if (!run || res.equals(""))
            return 0;
        if (flag == -1){
            try{
                q = Integer.parseInt(res);
            }
            catch (NumberFormatException exception){
                q = (int)Math.pow(2, 31) + 1;
            }
        }
        if (flag == 1){
            try{
                q = Integer.parseInt(res);
            }
            catch (NumberFormatException exception){
                q = (int)Math.pow(2, 31);
            }
        }
        return  flag * q;
    }
}