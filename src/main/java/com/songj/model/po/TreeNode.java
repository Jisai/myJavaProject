package com.songj.model.po;

import lombok.Data;

/**
 * @ClassNamee: TreeNode
 * @Description: 二叉树
 * @Author: Scott S
 * @Date: 2021-07-21 10:39
 * @Version: 1.0
 **/
@Data
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode next;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
