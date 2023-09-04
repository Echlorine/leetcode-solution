/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String res = String.valueOf(root.val);
        String left = serialize(root.left);
        String right = serialize(root.right);
        return res + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) return null;
        int i = 0;
        while (i < data.length() && data.charAt(i) == ',') i++;
        int last = i;
        while (i < data.length() && data.charAt(i) != ',') i++;
        if (data.substring(last, i) == null || data.substring(last, i).equals("")) return null;
        int val = Integer.valueOf(data.substring(last, i));
        last = i;
        int t = last;
        TreeNode root = new TreeNode(val);
        for(; i < data.length(); i++) {
            t = i;
            if (data.charAt(i) == ',') continue;
            while (i < data.length() && data.charAt(i) != ',') i++;
            int v = Integer.valueOf(data.substring(t, i));;
            if (v > val) break;
        }
        root.left = deserialize(data.substring(last, t));
        root.right = deserialize(data.substring(t));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;