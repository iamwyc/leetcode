package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class GetIntersectionNode {

  public static void main(String[] args) {
    System.out.println(new GetIntersectionNode());
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null)
      return null;
    ListNode a = headA, b = headB;
    while (a != b) {
      a = a != null ? a.next : headB;
      b = b != null ? b.next : headA;
    }
    return a;
  }
}
