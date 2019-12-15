package com.github.iamwyc.leetcode.node;

/**
 * @author iamwyc
 * @date 2019/12/14
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}
