package com.xander.sword;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路： 注意题目要求，每个空格替换。
 * 
 * 尾插的思想，碰到 ' ' 就用 “%20” 替换插入尾部，其他直接插尾部
 */
public class App02 {

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("We Are Happy.");
    System.out.println(stringBuffer);
    replaceSpace(stringBuffer);
    System.out.println(stringBuffer);
  }

  public static void replaceSpace(StringBuffer str) {
    int sCount = 0;
    int len = str.length();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == ' ') {
        sCount++;
      }
    }
    if (sCount == 0) {
      return;
    }
    int endIndex = len + sCount * 2;
    str.setLength(endIndex--);
    for (int i = len - 1; i >= 0; i--) {
      if (str.charAt(i) == ' ') {
        str.setCharAt(endIndex--, '0');
        str.setCharAt(endIndex--, '2');
        str.setCharAt(endIndex--, '%');
      } else {
        str.setCharAt(endIndex--, str.charAt(i));
      }
    }
  }
}