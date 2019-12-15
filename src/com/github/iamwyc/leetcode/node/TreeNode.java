package com.github.iamwyc.leetcode.node;

/**
 * @author iamwyc
 * @date 2019/12/14
 */
public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
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
