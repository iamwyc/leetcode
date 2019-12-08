package com.github.iamwyc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2019/12/8
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class HasCycle {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(0);
    ListNode n3 = new ListNode(4);
    ListNode n4 = new ListNode(3);

    head.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n1;
    System.out.println(hasCycle(head));
  }

  public static boolean hasCycle(ListNode head) {

    Set<ListNode> set = new HashSet<>();
    ListNode node = head;

    while (node != null) {

      if (set.contains(node)) {
        return true;
      }
      set.add(node);
      node = node.next;
    }

    return false;
  }

  /**
   * 速度最快
   *
   * 快指针走2步，慢指针走1步
   *
   */
  public boolean hasCycle2(ListNode head) {
    if (head != null && head.next != null) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
          return true;
        }
      }
    }
    return false;
  }
}
