package com.xander.sword.k

/**
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
object App03 {

    fun turnOverLinkedList(head: Node<String>): ArrayList<String> {
        // 先翻转
        var listSize = 0
        var node = head.next
        head.next = null
        while (node != null) {
            // println("1 node: $node")
            val tmp = node
            node = node.next
            val tail = head.next
            head.next = tmp
            tmp.next = tail
            listSize++
        }
        // 然后构建
        val list = ArrayList<String>(listSize)
        node = head.next
        while (null != node) {
            // println("2 node: $node")
            list.add(node.value)
            node = node.next
        }
        return list
    }

    class Node<T>(var value: T) {
        var next: Node<T>? = null

        fun link(nextValue: T): Node<T> {
            if (null == next) {
                next = Node(nextValue)
            } else {
                next?.value = nextValue
            }
            return next!!
        }

        override fun toString(): String {
            return value.toString()
        }
    }

}


fun main() {
    val head = App03.Node<String>("")
    head.link("9")
        .link("8")
        .link("7")
        .link("6")
        .link("5")
        .link("4")
        .link("3")
        .link("2")
        .link("1")
    val list = App03.turnOverLinkedList(head)
    list.forEach {
        print("$it ")
    }
}
