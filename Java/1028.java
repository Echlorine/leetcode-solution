/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1028 {
    public TreeNode recoverFromPreorder(String traversal) {
        return genTree(traversal, 0, traversal.length() - 1);
    }

    public TreeNode genTree(String str, int begin, int end) {
        if (begin == -1) return null;
        int depth = 0;
        // 确定当前深度
        for (int i = begin; i < end ; i++, depth++) 
            if (str.charAt(i) != '-') break;
        // 确定根结点
        int value = 0, border = 0;
        for (int i = begin + depth; i <= end ; i++, border++) {
            if (str.charAt(i) == '-') {value = Integer.valueOf(str.substring(begin + depth, i)); break;}
            if (i == end) value = Integer.valueOf(str.substring(begin + depth, i + 1));
        }
        // 确定左右子树位置
        int index = begin + depth + border;
        int lbegin = -1, rbegin = -1;
        int lend = end, rend = end;
        boolean flag = false;
        while (index < end) {
            int len = 0;
            for (int i = 0; i < end - index; i++, len++)
                if (Character.isDigit(str.charAt(index + i)))
                    break;
            if (len == depth + 1 && flag) {
                rbegin = index; // 右子树起始位置
                lend = rbegin - 1; // 左子树终止位置
                break;
            }
            if (len == depth + 1 && !flag) {
                lbegin = index; // 左子树起始位置
                flag = true;
            }
            while(index + len < end && Character.isDigit(str.charAt(index + len)))
                len++;
            index += len;
        }
        TreeNode root = new TreeNode(value); // 生成根节点
        root.left = genTree(str, lbegin, lend); // 生成左子树
        root.right = genTree(str, rbegin, rend); // 生成右子树
        return root;
    }
}