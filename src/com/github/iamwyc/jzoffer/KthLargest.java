package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class KthLargest {

  public static void main(String[] args) {
    System.out.println(new KthLargest());
  }

  int num, cur;

  public int kthLargest(TreeNode root, int k) {
    append(root, k);
    return num;
  }

  private void append(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    append(root.right, k);
    cur++;
    if (cur == k) {
      num = root.val;
      return;
    } else if (cur > k) {
      return;
    }
    append(root.left, k);
  }
}
