package com.xander.sword;

/**
 * 
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * 思路： 头插法，就是依次插入头部
 * 
 * 
 */

public class App15 {
    public static void main(String[] args) {
        Node head = new Node(-1);
        Node next = head.next;
        for (int i = 0; i < 10; i++) {
            if (null == next) {
                head.next = next = new Node(i);
            } else {
                next.next = new Node(i);
                next = next.next;
            }
        }
        print(head);
        head = revert(head);
        print(head);
    }

    public static Node revert(Node head) {
        // 拆成一个只有 head 的空链表和一个没有 head 的链表，
        // 没有 head 的链表的元素依次插入只有 head 的空链表的 head 后面；
        Node temp = head.next;
        head.next = null;

        while (null != temp) {
            Node hNext = head.next;
            head.next = temp;
            temp = temp.next;
            head.next.next = hNext;
        }
        return head;
    }

    private static void print(Node head) {
        Node next = head.next;
        while (null != next) {
            System.out.print(next.value);
            System.out.print("->");
            next = next.next;
        }
        System.out.println();
    }

    static class Node {
        int value;
        Node next;

        public Node(int v) {
            value = v;
        }
    }
}
