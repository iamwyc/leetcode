package com.github.iamwyc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode p1 = new TreeNode(9);
    TreeNode p12 = new TreeNode(20);
    TreeNode p2 = new TreeNode(15);
    TreeNode p22 = new TreeNode(7);

    root.left = p1;
    root.right = p12;
    p12.left = p2;
    p12.right = p22;
    System.out.println(levelOrderBottom(root));
  }

  public static List<List<Integer>> levelOrderBottom(TreeNode root) {


    List<List<Integer>> result = new LinkedList<>();
    if(root==null){
      return result;
    }
    List<TreeNode> tmp = new ArrayList<>();
    List<TreeNode> tmp2;
    tmp.add(root);
    while (!tmp.isEmpty()) {
      List<Integer> row = new ArrayList<>();
      tmp2 = new ArrayList<>();
      for (TreeNode node : tmp) {
        row.add(node.val);
        if (node.left != null) {
          tmp2.add(node.left);
        }
        if (node.right != null) {
          tmp2.add(node.right);
        }
      }
      result.add(0, row);
      tmp = tmp2;
    }
    return result;
  }

}
