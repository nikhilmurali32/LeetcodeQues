# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diam=0

        def height(root):
            if root is None:
                return -1
            leftH = 1+height(root.left)
            rightH = 1+height(root.right)
            self.diam = max(self.diam, leftH + rightH)
            return max(leftH,rightH)
        height(root)
        return self.diam