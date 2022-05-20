import java.util.*;

class Solution22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        res.clear(); //清除脏数据
        dfs(n, 0, 0, "");
        return res;
    }

    public void dfs(int n ,int lc, int rc, String str){
        if (lc == n && rc == n){
            res.add(str);
        }
        else{
            if (lc < n){
                dfs(n, lc+1, rc, str+"(");
            }
            if (lc > rc && rc < n){
                dfs(n, lc, rc+1, str+")");
            }
        }
    }
}