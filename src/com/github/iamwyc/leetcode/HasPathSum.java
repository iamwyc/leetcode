package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {

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
    TreeNode root = new TreeNode(5);
    TreeNode p1 = new TreeNode(4);
    TreeNode p12 = new TreeNode(8);
    TreeNode p2 = new TreeNode(11);
    TreeNode p22 = new TreeNode(13);
    TreeNode p23 = new TreeNode(4);
    TreeNode p3 = new TreeNode(7);
    TreeNode p32 = new TreeNode(2);
    TreeNode p33 = new TreeNode(1);

    root.left = p1;
    root.right = p12;

    p1.left = p2;
    p12.left = p22;
    p12.right = p23;

    p2.left = p3;
    p2.right = p32;
    p23.right = p33;

    System.out.println(hasPathSum(root, 27));
  }

  /**
   *
   * 踩坑题目
   * 必须是根节点到叶子节点的路径。
   * 1.叶子节点表示没有left和right
   * 2.只是根节点也不行
   */
  public static boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }
    if (hasPathSum0(root.right, sum, root.val)) {
      return true;
    }
    if (hasPathSum0(root.left, sum, root.val)) {
      return true;
    }
    return false;
  }

  public static boolean hasPathSum0(TreeNode node, int sum, int cur) {
    if (node == null) {
      return false;
    }
    cur = cur + node.val;
    if (cur == sum && node.left == null && node.right == null) {
      return true;
    }
    if (hasPathSum0(node.left, sum, cur)) {
      return true;
    }
    if (hasPathSum0(node.right, sum, cur)) {
      return true;
    }
    return false;
  }
}
