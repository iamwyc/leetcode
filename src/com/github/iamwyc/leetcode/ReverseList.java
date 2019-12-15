package com.github.iamwyc.leetcode;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2019/12/14
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

  public ListNode reverseListDiGui(ListNode pre,ListNode cur){
    if(cur==null) return pre;
    ListNode next = cur.next;
    cur.next = pre;
    return reverseListDiGui(cur,next);
  }

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode tmp = head.next;
    ListNode tmp2 = null;
    head.next = null;
    while (tmp != null) {
      tmp2 = tmp.next;
      tmp.next = head;
      head = tmp;
      tmp = tmp2;
    }
    return head;
  }
}
