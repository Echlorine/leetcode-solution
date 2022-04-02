import java.util.*;

class MinStack {
    
    private List<Long> ans; // 用ArrayList实现
    private long diff; // 记录当前值与最小值的差值
    private long minv; // 记录当前最小值

    public MinStack() {
        ans = new ArrayList<>();
    }
    
    public void push(int val) {
        if (ans.isEmpty()) minv = val;
        diff = val - minv;
        if (diff >= 0) ans.add(diff);
        else {
            minv = val;
            ans.add(diff); // 这个时候 diff + minv 就是次小值
        }
    }
    
    public void pop() {
        diff = ans.get(ans.size() - 1);
        if (diff >= 0) ans.remove(ans.size() - 1);
        else {
            ans.remove(ans.size() - 1);
            minv = minv - diff;
        }
    }
    
    public int top() {
        diff = ans.get(ans.size() - 1);
        if (diff >= 0) return (int) (diff + minv);
        else return (int) minv;
    }
    
    public int getMin() {
        return (int) minv;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */