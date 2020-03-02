package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class IsBalanced {

  public static void main(String[] args) {
    System.out.println(new IsBalanced());
  }

  boolean isBalanced = true;

  public boolean isBalanced(TreeNode root) {
    deep(root, 0);
    return isBalanced;
  }


  private int deep(TreeNode root, int cur) {
    if (root == null) {
      return cur;
    }
    int l = deep(root.right, cur + 1);
    int r = deep(root.left, cur + 1);
    if (Math.abs(l - r) > 1) {
      isBalanced = false;
    }
    return Math.max(l, r);
  }
}
