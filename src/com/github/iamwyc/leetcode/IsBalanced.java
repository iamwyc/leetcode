package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class IsBalanced {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
          "val=" + val +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode p1 = new TreeNode(9);
    TreeNode p12 = new TreeNode(20);
    TreeNode p2 = new TreeNode(15);
    TreeNode p22 = new TreeNode(7);
    TreeNode p3 = new TreeNode(7);

    root.left = p1;
    root.right = p12;

    p12.left = p2;
    p12.right = p22;

    System.out.println(root);
    System.out.println(isBalanced(root));
  }

  public static boolean isBalanced(TreeNode root) {
    return process(root) != -1;
  }

  /**
   *求深度的变形
   */
  public static int process(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = process(root.left);
    if (left == -1) {
      return -1;
    }
    int right = process(root.right);
    if (right == -1) {
      return -1;
    }
    return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
  }

}
