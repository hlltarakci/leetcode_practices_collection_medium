// https://leetcode.com/problems/binary-tree-inorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        time: O(n)
        space: O(n) -- worst case unbalanced tree.. it is O(log n) for balanced tree
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()) {
                current = stack.pop();
                list.add(current.val);
                
                current = current.right;
            }
            
        };
        
        return list;
    }
}
