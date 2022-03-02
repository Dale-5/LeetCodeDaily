package com.dale.leetcodedaily.day211225;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int n = queue.size(), prev = flag ? 0 : Integer.MAX_VALUE;
            while (n-- > 0) {
                TreeNode top = queue.remove();
                if (flag && (top.val % 2 == 0 || top.val <= prev) || !flag && (top.val % 2 != 0 || top.val >= prev))
                    return false;
                prev = top.val;
                if (top.left != null)
                    queue.add(top.left);
                if (top.right != null)
                    queue.add(top.right);
            }
            flag = !flag;
        }
        return true;
    }
}

public class EvenOddTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null),
                new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))));
        Solution s = new Solution();
        System.out.println(s.isEvenOddTree(root));
    }
}
