import java.util.*;

class Solution42 {
    public int trap(int[] height) {
        // 思路: 找到最高值与次高值，分段
        int max = 0, imax = -1;
        int res = 0;
        Map<Integer, Integer> moul = new TreeMap<>(); // 记录各个山峰与其下标
        for (int i =0; i < height.length; i++)
            if (height[i] >= max && height[i] != 0) {moul.put(i, height[i]); max = height[i]; imax = i;}
        // 最大数不在最后面，还得继续遍历数组，找到小山峰
        if (imax < height.length - 1){
            max = 0;
            for (int i = height.length - 1; i > imax; i--)
                if (height[i] >= max && height[i] != 0) {moul.put(i, height[i]); max = height[i];}
        }

        // for (Integer m : moul.keySet())
        // System.out.println("key: " + m + " value: " + moul.get(m));

        // 计算最低雨水游标
        int cursor = 0;
        int begin = 0;
        for (Integer m : moul.keySet()) {
            cursor = moul.get(m);
            begin = m;
            break;
        }
        // 计算雨水体积
        for (int i = begin; i <= imax; i++){
            if (!moul.containsKey(i)) res += cursor - height[i];
            else cursor = moul.get(i);
        }
        // 同样考虑最大数不在最后面的情况
        if (imax < height.length - 1){
            for (Integer m : moul.keySet()) {
                cursor = moul.get(m);
                begin = m;
            }
            for (int i = begin; i > imax; i--){
                if (!moul.containsKey(i)) res += cursor - height[i];
                else cursor = moul.get(i);
            }
        }
        System.out.println(imax);
        return res;
    }
}