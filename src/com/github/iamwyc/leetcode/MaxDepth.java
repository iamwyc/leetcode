package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

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
    TreeNode p1 = new TreeNode(3);
    TreeNode p12 = new TreeNode(3);
    TreeNode p2 = new TreeNode(3);
    TreeNode p22 = new TreeNode(3);

    root.left = p1;
    root.right = p12;
    p12.left = p2;
    p12.right = p22;
    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root) {
    return findDeep(root, 0);
  }

  private static int findDeep(TreeNode node, int cur) {

    if (node == null) {
      return cur;
    }
    int left = findDeep(node.left, cur + 1);

    int right = findDeep(node.right, cur + 1);

    return Math.max(left, right);
  }
}
