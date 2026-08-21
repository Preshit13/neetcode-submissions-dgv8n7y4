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

class Solution {
        int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    public void dfs(TreeNode root, int max){
        if(root == null) return;

        if(root.val >= max){
            count++;  // good node!
        }

        max = Math.max(max, root.val);  // update max!

        dfs(root.left, max);   // pass updated max!
        dfs(root.right, max);  // pass updated max!
    }
}
