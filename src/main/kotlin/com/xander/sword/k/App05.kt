package com.xander.sword.k

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 栈的特点就是先进后出 队列的特点就是先进先出
 *
 */
class App05<T> {

    private var inStack = Stack<T>()
    private var outStack = Stack<T>()

    /**
     * 入队列
     */
    fun push(data: T) {
        inStack.push(data)
    }

    /**
     * 出队列
     */
    fun pop(): T? {
        val outData: T? = outStack.pop()
        if (null != outData) {
            return outData
        }
        do {
            val inData = inStack.pop() ?: break
            outStack.push(inData)
        } while (true)
        return outStack.pop()
    }

    /**
     * 栈
     */
    private class Stack<T> {

        private val list = mutableListOf<T>()


        fun hasNext(): Boolean {
            return list.isNotEmpty()
        }

        /**
         * 入栈
         */
        fun push(data: T) {
            list.add(data)
        }

        /**
         * 出栈
         */
        fun pop(): T? {
            if (list.isEmpty()) {
                return null
            }
            return list.removeLast()
        }

    }

}

fun main() {
    val tool = App05<Int>()
    tool.push(1)
    tool.push(2)
    assert(tool.pop() == 1)
    tool.push(3)
    assert(tool.pop() == 2)
    tool.push(4)
    assert(tool.pop() == 3)
    assert(tool.pop() == 4)
}