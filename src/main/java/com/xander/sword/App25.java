package com.xander.sword;

import java.util.ArrayList;
import java.util.Random;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 
 * 另一个特殊指针random指向一个随机节点），
 * 
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（
 * 
 * 注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 */
public class App25 {

    public static void main(String[] args) {
        ArrayList<RandomListNode> nodes = new ArrayList<>();
        RandomListNode head = null;
        RandomListNode tmp = null;
        for (int i = 0; i < 10; i++) {
            if (null == head) {
                head = new RandomListNode(i);
                tmp = head;
                nodes.add(head);
            } else {
                RandomListNode t = new RandomListNode(i);
                tmp.next = t;
                nodes.add(t);
                tmp = t;
            }
        }
        tmp = head;
        Random random = new Random();
        for (int i = 0, len = nodes.size(); i < len; i++) {
            int randomIndex = Math.abs(random.nextInt()) % len;
            if (0 <= randomIndex && randomIndex < len) {
                tmp.random = nodes.get(randomIndex);
            }
            System.out.print("\nrandom:" + tmp.random);
            tmp = tmp.next;
        }
        System.out.println("");
        tmp = head;
        while (null != tmp) {
            System.out.print(tmp + "(" + tmp.random + ")->");
            tmp = tmp.next;
        }
        System.out.println("");
        RandomListNode clone = Clone(head);
        tmp = clone;
        while (null != tmp) {
            System.out.print(tmp + "(" + tmp.random + ")->");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    // 第一步，复制节点，放到原节点后面，
    // 第二步，复制随机节点关系，
    // 第三步，断开新建节点和原节点之间的关系。
    public static RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return null;
        }
        // copy
        RandomListNode tmp = pHead;
        while (null != tmp) {
            RandomListNode tmpNext = tmp.next;
            RandomListNode copy = new RandomListNode(tmp.label);
            tmp.next = copy;
            copy.next = tmpNext;
            tmp = tmpNext;
        }
        // link random
        tmp = pHead;
        while (null != tmp) {
            if (null != tmp.random) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        // unlink
        RandomListNode cloneHead = pHead.next;
        tmp = pHead;
        while (null != tmp) {
            RandomListNode tmpCopy = tmp.next;
            RandomListNode tmpNext = tmp.next.next;
            tmp.next = tmpNext;
            if (null == tmpNext) {
                tmpCopy.next = null;
            } else {
                tmpCopy.next = tmpNext.next;
            }
            tmp = tmpNext;
        }
        return cloneHead;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

}
