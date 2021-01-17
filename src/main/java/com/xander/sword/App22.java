package com.xander.sword;

/**
 * 
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are
 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 */
public class App22 {

    public static void main(String[] args) {
        App22 App22 = new App22();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We  Are  Happy");
        System.out.println(App22.replaceSpace(stringBuffer));
    }

    public String replaceSpace(StringBuffer stringBuffer) {
        if (null == stringBuffer) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int len = stringBuffer.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = stringBuffer.charAt(i);
            if (c == ' ') {
                sb.append("02%");
            } else {
                sb.append(c);
            }
        }
        sb.reverse();
        return sb.toString();
    }
}