package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class MergeTwoLists {

  public static void main(String[] args) {
    System.out.println(new MergeTwoLists());
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode t1 = l1;
    ListNode t2 = l2;
    ListNode n = null;
    if (t1.val < t2.val) {
      n = mergeTwoLists(l1.next, l2);
      t1.next = n;
      return t1;
    } else {
      n = mergeTwoLists(l1, l2.next);
      t2.next = n;
      return t2;
    }
  }
}
