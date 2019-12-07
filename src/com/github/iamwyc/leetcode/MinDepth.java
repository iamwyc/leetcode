package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {

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
    System.out.println(minDepth(root));
  }

  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // null节点不参与比较
    if (root.left == null && root.right != null) {
      return 1 + minDepth(root.right);
    }
    // null节点不参与比较
    if (root.right == null && root.left != null) {
      return 1 + minDepth(root.left);
    }

    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}
