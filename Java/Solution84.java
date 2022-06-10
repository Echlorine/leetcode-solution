import java.util.*;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> temp = new Stack<>();
        int[] lbor = new int[heights.length];
        int[] rbor = new int[heights.length];
        // 判断左边界
        for (int i = 0; i < heights.length; i++){
            while (!temp.isEmpty() && heights[temp.peek()] >= heights[i])
                temp.pop(); // 不断弹出比自己大的元素
            if (temp.isEmpty()) lbor[i] = -1;
            else lbor[i] = temp.peek();
            temp.push(i); // 当前元素入栈
        }
        temp.clear();
        // 判断右边界
        for (int i = heights.length - 1; i >= 0; i--){
            while (!temp.isEmpty() && heights[temp.peek()] >= heights[i])
                temp.pop(); // 不断弹出比自己大的元素
            if (temp.isEmpty()) rbor[i] = heights.length;
            else rbor[i] = temp.peek();
            temp.push(i); // 当前元素入栈
        }
        // 计算面积
        for (int i = 0; i < heights.length; i++){
            if (heights[i] * (rbor[i] - lbor[i] - 1) >= res) res = heights[i] * (rbor[i] - lbor[i] - 1);
        }
        return res;
    }
}