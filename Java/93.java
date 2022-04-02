import java.util.*;

class Solution93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        if (len > 12)
            return res;
        for (int i=1; i<4; i++){
            if (len - i > 9)
                continue;
            if (len - i < 3)
                break;
            if (i != 1 && (Integer.parseInt(s, 0, i, 10)<10 || Integer.parseInt(s, 0, i, 10)>255))
                break;
            for (int j=1; j<4; j++){
                if (len - i - j > 6)
                    continue;
                if (len -i -j < 2)
                    break;
                if (j != 1 && (Integer.parseInt(s, i, i+j, 10)<10 || Integer.parseInt(s, i, i+j, 10)>255))
                    break;
                for (int k=1; k<4; k++){
                    if (len - i -j -k > 3)
                        continue;
                    if (len - i -j -k < 1)
                        break;
                    if (k != 1 && (Integer.parseInt(s, i+j, i+j+k, 10)<10 || Integer.parseInt(s, i+j, i+j+k, 10)>255))
                        break;
                    if ((len -i -j -k != 1 && Integer.parseInt(s, i+j+k, i+j+k+1, 10) ==0) || Integer.parseInt(s, i+j+k, len, 10) > 255)
                        continue;
                    String temp = "";
                    temp += s.substring(0,i);
                    temp += ".";
                    temp += s.substring(i,i+j);
                    temp += ".";
                    temp += s.substring(i+j,i+j+k);
                    temp += ".";
                    temp += s.substring(i+j+k,len);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}


/**
 *ipV4(第4版)地址的范围是1.0.0.0～254.255.255.254，由4节组成，每节取值范围0～255。
 但有一些地址是特殊的，不能算作”有效值“。特殊的有‍：‍
 *255.255.255.255也是广播地‍‍址，255开头的‍不可使用。
 *每个网段的最后一个ip是广播地址，不能被某一个电脑使用。比如192.168.1.255（255不能使用）。可以理解为255结尾的不可使用。
 *127.0.0.1是表示自己，不能用于电脑间的通讯，127开头的不可用。
 *0.0.0.0表示无效地址，故不可用。
 */