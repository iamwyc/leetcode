package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class MaxDepth {

  public static void main(String[] args) {
    System.out.println(new MaxDepth());
  }

  public int maxDepth(TreeNode root) {
    return deep(root, 0);
  }

  private int deep(TreeNode root, int cur) {
    if (root == null) {
      return cur;
    }
    return Math.max(deep(root.right, cur + 1), deep(root.left, cur + 1));
  }
}
