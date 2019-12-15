package com.github.iamwyc.leetcode;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2019/12/15
 */
public class DeleteNode {

  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    ListNode n1 = new ListNode(5);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(9);
    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    System.out.println(head);
    new DeleteNode().deleteNode(n1);
    System.out.println(head);
  }

  /**
   *将下一个节点的值赋值到node。node.next=node.next.next
   */
  public void deleteNode(ListNode node) {
    ListNode next = node.next;
    node.val = next.val;
    node.next = next.next;
  }
}
