/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    StringBuilder series = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 先根遍历该二叉树
        pre_order(root);
        return series.toString();
    }

    public void pre_order(TreeNode root) {
        // 递归出口
        if (root == null) {series.append("#,"); return;}
        // 根节点
        series.append(String.valueOf(root.val) + ",");
        // 左节点
        pre_order(root.left);
        // 右节点
        pre_order(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataarray = data.split(",");
        return gen_tree(dataarray, new int[] {0});
    }

    public TreeNode gen_tree(String[] strs, int[] i) {
        if (strs[i[0]].equals("#"))
            {i[0]++; return null;}
        // 根节点
        TreeNode root = new TreeNode(Integer.valueOf(strs[i[0]]));
        i[0]++;
        // 递归构造左子树
        root.left = gen_tree(strs, i);
        // 递归构造右子树
        root.right = gen_tree(strs, i);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));