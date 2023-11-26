package com.xander.sword.k

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 */
object App04 {

    /**
     * 思路是按前序和中序的打印顺序特点，区分节点的左节点和右节点，用递归的方法来构建二叉树
     * @param frontList 前序序列
     * @param frontStart 前序开始索引
     * @param frontEnd 前序结束索引
     * @param midList 中序序列
     * @param midStart 中序开始索引
     * @param midEnd 中序结束索引
     *
     */
    fun buildTree(
        frontList: List<Int>,
        frontStart: Int,
        frontEnd: Int,
        midList: List<Int>,
        midStart: Int,
        midEnd: Int
    ): Node? {
        var root: Node? = null
        if (frontStart >= frontEnd || midStart >= midEnd) {
            // 超过范围
            return root
        }
        root = Node(frontList[frontStart])
        var rootInMid = -1
        for (i in midStart until midEnd) {
            if (midList[i] == root.data) {
                rootInMid = i
                break
            }
        }
        if (rootInMid == -1) {
            // 没找到 root
            return root
        }
        val leftCount = rootInMid - midStart
        root.left = buildTree(frontList, frontStart + 1, frontStart + 1 + leftCount, midList, midStart, rootInMid)
        root.right = buildTree(frontList, frontStart + 1 + leftCount, frontEnd, midList, rootInMid + 1, midEnd)
        return root
    }

    class Node(var data: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}

fun main() {
    val frontList = listOf(1, 2, 4, 7, 3, 5, 6, 8)
    val midList = listOf(4, 7, 2, 1, 5, 3, 8, 6)
    val tree = App04.buildTree(frontList, 0, frontList.size, midList, 0, midList.size)
    println(true)
}