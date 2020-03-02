package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class GetKthFromEnd {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(3);
    ListNode n3 = new ListNode(4);
    ListNode n4 = new ListNode(5);
    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    System.out.println(head);
    System.out.println(new GetKthFromEnd().getKthFromEnd(head, 2));
  }

  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode t = head;
    int len = 0;
    while (t != null) {
      t = t.next;
      len++;
    }
    t = head;
    int c = len - k;
    len = 0;
    while (t != null) {
      if (len == c) {
        return t;
      }
      len++;
      t = t.next;
    }
    return null;
  }
}
