package com.xander.sword.k

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are Happy. 则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路： 注意题目要求，每个空格替换。
 *
 * 尾插的思想，碰到 ' ' 就用 “%20” 替换插入尾部，其他直接插尾部
 */
object App02 {

    fun transform(originStr: String?): String {
        val sb = StringBuffer()
        originStr?.let {
            for (index in it.indices) {
                val char = it.get(index)
                if (char == ' ') {
                    sb.append("%20")
                } else {
                    sb.append(char)
                }
            }
        }
        return sb.toString()
    }
}


fun main() {
    println(App02.transform("We Are Happy."))
}