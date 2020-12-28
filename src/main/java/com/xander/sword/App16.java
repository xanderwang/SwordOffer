package com.xander.sword;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class App16 {

  public ListNode Merge(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(-1);
    ListNode p = null;
    while (!(list1 == null && list2 == null)) {
      ListNode tmp = null;
      if (list1 == null) {
        tmp = list2;
        list2 = list2.next;
      } else if (list2 == null) {
        tmp = list1;
        list1 = list1.next;
      } else {
        if (list1.val > list2.val) {
          tmp = list2;
          list2 = list2.next;
        } else {
          tmp = list1;
          list1 = list1.next;
        }
      }
      if (null == p) {
        p = tmp;
        head.next = p;
      } else {
        p.next = tmp;
        p = p.next;
      }
    }
    return head.next;
  }

  static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
}
