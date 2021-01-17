package com.xander.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class App27 {

    public static void main(String[] args) {
        Permutation("acab").forEach(new Consumer<String>() {
            public void accept(String t) {
                System.out.println(t);
            };
        });
    }

    public static ArrayList<String> Permutation(String str) {
        if (null == str || "" == str.trim()) {
            return null;
        }
        str = str.trim();
        List<Character> chars = new ArrayList<>();
        for (int i = 0, len = str.length(); i < len; i++) {
            chars.add(str.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (chars.get(j) > chars.get(j + 1)) {
                    Character tmp = chars.get(j + 1);
                    chars.set(j + 1, chars.get(j));
                    chars.set(j, tmp);
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        all(result, sb, chars);
        return result;
    }

    public static void all(List<String> result, StringBuffer sb, List<Character> chars) {
        if (chars.isEmpty()) {
            // 已经没有选择了，说明到底了
            result.add(sb.toString());
            return;
        }
        System.out.println(chars);
        for (int i = 0, len = chars.size(); i < len; i++) {
            Character ch = chars.remove(i);
            if (i > 0 && ch == chars.get(i - 1)) {
                chars.add(i, ch);
                continue;
            }
            sb.append(ch);
            all(result, sb, chars);
            chars.add(i, ch);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
