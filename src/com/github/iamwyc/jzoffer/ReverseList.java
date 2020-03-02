package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class ReverseList {

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
    System.out.println(new ReverseList().reverseList(head));
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode one = head;
    ListNode two = head.next;
    if (two == null) {
      return one;
    }
    one.next = null;
    ListNode three = two.next;
    while (three != null) {
      two.next = one;
      one = two;
      two = three;
      three = three.next;
    }
    two.next = one;
    return two;
  }
}
