import java.util.*;

class Solution71 {
    public String simplifyPath(String path) {
        List<String> strpath = new LinkedList<>();
        // 处理所有的表征路径的字符串
        int index = -1; // index 指向上一个具有意义的 /
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') { // 当前的 / 无意义
                if (i > 0 && path.charAt(i - 1) == '/') {
                    index++;
                    continue;
                }
                else { // 当前的 / 有意义
                    if (index != -1) strpath.add(path.substring(index + 1, i));
                    index = i;
                }
            }
        }
        if (path.charAt(path.length() - 1) != '/')
            strpath.add(path.substring(index + 1, path.length()));
        // 拼接路径
        Deque<String> stack = new ArrayDeque<>();
        for (String str : strpath) {
            if (str.equals("..")) {
                if (stack.size() != 0) stack.removeLast();
            }
            else if (str.equals(".")) {
                continue;
            }
            else {
                stack.addLast("/" + str);
            }
        }
        if (stack.size() == 0) return "/";
        StringBuilder res = new StringBuilder();
        for (String str : stack)
            res.append(str);
        return res.toString();
    }
}