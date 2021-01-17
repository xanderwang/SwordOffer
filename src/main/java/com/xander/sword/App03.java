package com.xander.sword;

import java.util.ArrayList;

/**
 * 
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 
 */

public class App03 {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        App03 app = new App03();
        ListNode head = new ListNode(1);
        ListNode pre = head;
        for (int i = 2; i < 9; i++) {
            ListNode tmp = new ListNode(i);
            pre.next = tmp;
            pre = pre.next;
        }
        ArrayList<Integer> res = app.printListFromTailToHead(head);
        System.out.println(res);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(0);
        while (listNode != null) {
            ListNode headNext = head.next;
            head.next = listNode;
            listNode = listNode.next;
            head.next.next = headNext;
        }
        ArrayList<Integer> res = new ArrayList<>();
        ListNode p = head.next;
        while (p != null) {
            res.add(p.val);
            p = p.next;
        }
        return res;
    }
}