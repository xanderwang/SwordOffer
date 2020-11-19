package com.xander.sword;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 解法:
 * 快慢指针来做，先走 k 个节点，然后两个指针一起走，
 * 最后第一个先走的走到结尾了，第二个指针就是要找的结点。
 */

public class App14 {
  public static void main(String[] args) {
    Node head = new Node(0);
    Node p = head;
    for (int i = 1; i < 10; i++) {
      Node temp = p.next = new Node(i);
      p = temp;
    }
    System.out.println(findKNode(head, 4));
  }

  static Node findKNode(Node head, int k) {
    Node p = head, q = null;
    for (int i = 0; i < k; i++) {
      if (p == null) {
        // 说明链表结点数少于 k
        return q;
      }
      p = p.next;
    }
    q = head;
    while (null != p) {
      p = p.next;
      q = q.next;
    }
    return q;
  }

  static class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value + "";
    }
  }

}
