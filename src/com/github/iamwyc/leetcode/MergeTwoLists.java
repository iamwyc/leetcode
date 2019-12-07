package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
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

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l14 = new ListNode(4);

    ListNode l2 = new ListNode(1);
    ListNode l23 = new ListNode(3);
    ListNode l24 = new ListNode(4);
    l1.next = l12;
    l12.next = l14;
    l14.next = null;

    l2.next = l23;
    l23.next = l24;
    l24.next = null;
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(mergeTwoLists(l1, l2));
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    ListNode result = null;
    if (l1.val < l2.val) {
      result = new ListNode(l1.val);
      l1 = l1.next;
    } else {
      result = new ListNode(l2.val);
      l2 = l2.next;
    }
    ListNode tmp = result;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        tmp.next = new ListNode(l2.val);
        l2 = l2.next;
      } else if (l2 == null) {
        tmp.next = new ListNode(l1.val);
        l1 = l1.next;
      } else if (l1.val < l2.val) {
        tmp.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        tmp.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      tmp = tmp.next;
    }
    return result;
  }

}
