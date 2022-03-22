package com.songj.algorithm.leetcode;

import com.songj.model.po.TreeNode;

import java.util.*;

/**
 * @ClassNamee: Topic_94    二叉树前序遍历、中序遍历、后序遍历
 * @Description:    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/
 * @Author: Scott S
 * @Date: 2022-02-09 16:49
 * @Version: 1.0
 **/
public class Topic_94 {




    //二叉树前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        preorder_1(root, list);
        return list;
    }

    //二叉树前序遍历【递归】
    public void preorder_1(TreeNode cur, List<Integer> list){
        if(cur == null){
            return;
        }
        list.add(cur.getVal());
        preorder_1(cur.getLeft(), list);
        preorder_1(cur.getRight(), list);
    }

    //二叉树中序遍历【递归】
    public void inorder_1(TreeNode root, List<Integer> list){
        if(root ==null){
            return;
        }
        inorder_1(root.getLeft(), list);
        list.add(root.getVal());
        inorder_1(root.getRight(), list);
    }

    //二叉树后序遍历【递归】
    public void postorder_1(TreeNode root, List<Integer> list){
        if(root ==null){
            return;
        }
        inorder_1(root.getLeft(), list);
        inorder_1(root.getRight(), list);
        list.add(root.getVal());
    }



    //二叉树前序遍历【非递归】
    public List<Integer> preorder_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //加个边界条件判断
        if (root == null){ return res;}

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//压栈
        while (!stack.empty()) {
            TreeNode t1 = stack.pop();//出栈
            res.add(t1.getVal());
            if (t1.getRight() != null) {
                stack.push(t1.getRight());
            }
            if (t1.getLeft() != null) {
                stack.push(t1.getLeft());
            }
        }
        return res;
    }

    //二叉树中序遍历【非递归】
    public List<Integer> inorder_2(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.getLeft();
            }
            if(!stack.empty()){
                root = stack.pop();
                list.add(root.getVal());
                root = root.getRight();
            }
        }
        return list;
    }

    //二叉树后序遍历【非递归】
    //仔细观察可以发现后序遍历的结果与先序遍历右子树的结果是倒序关系
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            if(root != null){
                stack.push(root);
                stack.push(null);
                if(root.getRight() != null){
                    stack.push(root.getRight());
                }
                if(root.getLeft() != null){
                    stack.push(root.getLeft());
                }
            } else{
                res.add(stack.pop().getVal());
            }

        }
        return res;
    }


}
