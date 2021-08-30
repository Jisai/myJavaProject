package com.songj.algorithm.leetcode;

import com.songj.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassNamee: Topic_617   https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @Description:    合并二叉树
 * @Author: Scott S
 * @Date: 2021-07-21 10:07
 * @Version: 1.0
 **/
public class Topic_617 {



    /**
     * 方法一：深度优先搜索
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.getVal() + t2.getVal());
        merged.setLeft(mergeTrees(t1.getLeft(), t2.getLeft()));
        merged.setRight(mergeTrees(t1.getRight(), t2.getRight()));
        return merged;
    }



    /**
     * 方法二：广度优先搜索
     */
    public TreeNode mergeTrees_2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.getVal() + t2.getVal());
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.getLeft(), left2 = node2.getLeft(), right1 = node1.getRight(), right2 = node2.getRight();
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.getVal() + left2.getVal());
                    node.setLeft(left);
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.setLeft(left1);
                } else if (left2 != null) {
                    node.setLeft(left2);
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.getVal() + right2.getVal());
                    node.setRight(right);
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.setRight(right1);
                } else {
                    node.setRight(right2);
                }
            }
        }
        return merged;
    }



}
