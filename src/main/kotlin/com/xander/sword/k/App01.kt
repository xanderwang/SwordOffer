package com.xander.sword.k

/**
 *
 * 题目： 在一个二维数组中（每个一维数组的长度相同）， 每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 分析： 暴力法，直接全部遍历，这个方法一定是可以的。 但是是不是最优的呢？ 显然不是。 因为有额外的条件，比如同行，是递增的，同列，也是递增的。
 * 可以利用这个特性先确定列，然后从这个列开始依次找。
 */
object App01 {

    fun find(dataArray: Array<IntArray>, target: Int): Boolean {
        // 缩小范围在遍历比直接遍历要好
        // 找到第一行，第一个比目标值大的列
        var maxColumn = -1
        var row: IntArray = dataArray[0]
        for (i in row.indices) {
            if (row[i] > target) {
                maxColumn = i - 1
                break
            }
        }
        println("maxColumn: $maxColumn")
        // 找到最后一行，最后一个比目标小的列
        var minColumn = -1
        row = dataArray[dataArray.size - 1]
        for (i in row.indices) {
            if (row[i] < target) {
                minColumn = i + 1
            }
        }
        println("minColumn: $minColumn")
        if (maxColumn < minColumn || maxColumn == -1 || minColumn >= dataArray[0].size) {
            return false
        }
        // 在缩小的范围里面查找
        dataArray.forEach { dataRow ->
            for (i in minColumn..maxColumn) {
                if (dataRow.get(i) == target) {
                    return true
                }
            }
        }
        return false
    }
}

fun main() {

    val dataArray: Array<IntArray> =
        arrayOf(
            intArrayOf(1, 11, 21, 31, 41, 51, 61, 71, 81, 91),
            intArrayOf(2, 12, 22, 32, 42, 52, 62, 72, 82, 92),
            intArrayOf(3, 13, 23, 33, 43, 53, 63, 73, 83, 93),
            intArrayOf(4, 14, 24, 34, 44, 54, 64, 74, 84, 94),
            intArrayOf(5, 15, 25, 35, 45, 55, 65, 75, 85, 95),
            intArrayOf(6, 16, 26, 36, 46, 56, 66, 76, 86, 96),
        )
    println(App01.find(dataArray, 52))
}
