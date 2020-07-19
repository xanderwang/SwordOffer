package com.xander.sword;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 栈的特点就是先进后出 队列的特点就是先进先出
 * 
 */

public class App05 {

  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();

  public static void main(String[] args) {
    App05 app05 = new App05();
    app05.push(2);
    app05.push(3);
    app05.push(4);
    System.out.println(app05.pop());
    app05.push(5);
    System.out.println(app05.pop());
    System.out.println(app05.pop());
    app05.push(6);
    System.out.println(app05.pop());
    System.out.println(app05.pop());
  }

  void push(Integer data) {
    stack1.push(data);
  }

  int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      return -1;
    }
    return stack2.pop();
  }
}