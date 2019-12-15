package com.github.iamwyc.leetcode;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2019/12/14
 */
public class IsPalindrome2 {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(1);
    ListNode n4 = new ListNode(5);
    head.next = n1;
    n1.next = n2;
//    n2.next = n3;
//    n3.next = n4;
    System.out.println(head);
    System.out.println(new IsPalindrome2().isPalindrome(head));
  }

  public boolean isPalindrome(ListNode head) {
    StringBuilder sb = new StringBuilder();
    StringBuilder sb1 = new StringBuilder();

    while (head != null) {
      sb.append(head.val);
      sb1.insert(0, head.val);
      head = head.next;
    }
    return sb.toString().equals(sb1.toString());
  }


  /**
   *时间O(n) 空间O(1)
   */
  public boolean isPalindrome2(ListNode head) {
    // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
    if (head == null || head.next == null) {
      return true;
    }
    ListNode fast = head;
    ListNode slow = head;
    // 根据快慢指针，找到链表的中点
    //快指针走2步,慢指针走1步
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    //把后半段的反转
    slow = reverse(slow.next);

    while (slow != null) {
      if (head.val != slow.val) {
        return false;
      }
      head = head.next;
      slow = slow.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    // 递归到最后一个节点，返回新的新的头结点
    if (head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
