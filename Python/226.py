# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        # 特例，空二叉树
        if not root:
            return root
        # 递归生成根节点
        p = TreeNode(val = root.val)
        # 递归生成左子树
        if root.right:
            p.left = self.invertTree(root.right)
        # 递归生成右子树
        if root.left:
            p.right = self.invertTree(root.left)
        return p