package com.github.iamwyc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

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
    ListNode root = new ListNode(1);
    ListNode q2 = new ListNode(2);
    ListNode q3 = new ListNode(3);
    ListNode q4 = new ListNode(4);
    ListNode q5 = new ListNode(5);
    root.next = q2;
    q2.next = q3;
    q3.next = q4;
    q4.next = q5;
    q5.next = null;
    System.out.println(root);
    System.out.println(removeNthFromEnd(root, 5));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode node = head;
    List<ListNode> tmp = new ArrayList<ListNode>();
    while (node != null) {
      tmp.add(node);
      node = node.next;
    }
    int index = tmp.size() - n;
    ListNode p = tmp.get(index);
    if (index == 0) {
      return p.next;
    } else {
      ListNode p1 = tmp.get(index - 1);
      p1.next = p.next;
    }
    return head;
  }


  /**
   * 速度最快的
   * 快慢指针。
   * 第一个循环：让快指针和慢指针相隔n个位置
   * 第二个循环：同时往前周。直到快到尾部时，慢指针则到了指定地点
   */
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode node = new ListNode(0);
    node.next = head;
    ListNode l = node;
    ListNode r = node;
    int i = 0;
    while (i <= n) {
      r = r.next;
      i++;
    }
    while (r != null) {
      r = r.next;
      l = l.next;
    }
    l.next = l.next.next;
    return node.next;
  }
}
