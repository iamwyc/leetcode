package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 * /           \
 * 2             2
 *
 * [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 *
 * [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class IsSameTree {

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
    TreeNode p = new TreeNode(1);
    TreeNode q = new TreeNode(1);

    TreeNode p2 = new TreeNode(5);
    TreeNode p3 = new TreeNode(15);

    TreeNode q2 = new TreeNode(2);
    TreeNode q3 = new TreeNode(2);

    p.left = p2;
    p.right = null;
    q.right = null;
    q.left = q3;
    System.out.println(p);

    System.out.println(q);
    System.out.println(isSameTree(p, q));
  }

  public static boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == q) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    if (!isSameTree(p.left, q.left)) {
      return false;
    }
    return isSameTree(p.right, q.right);
  }
}
