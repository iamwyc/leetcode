package com.github.iamwyc.cxymsbd;

import com.github.iamwyc.leetcode.node.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2020/3/2
 */
public class RemoveDuplicateNodes {

  public static void main(String[] args) {

    ListNode r=new ListNode(1);
    r.next=new ListNode(2);
    r.next.next=new ListNode(3);
    r.next.next.next=new ListNode(3);
    r.next.next.next.next=new ListNode(2);
    r.next.next.next.next.next=new ListNode(1);
    System.out.println(new RemoveDuplicateNodes().removeDuplicateNodes(r));
  }

  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    Set<Integer> s = new HashSet<>();
    s.add(head.val);
    ListNode node = head;
    ListNode next = head.next;
    while (next != null) {
      if (s.contains(next.val)) {
        next = next.next;
        node.next = next;
      } else {
        node = next;
        next = next.next;
        s.add(node.val);
      }
    }
    return head;
  }
}
