package com.fqh.codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 我劝你荔枝
 * @version 1.0
 * Date: 2022/4/27 22:24:29
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_232 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    static class MyQueue {
        LinkedList<Integer> stack1; //不使用Stack【底层是Vector效率低】
        LinkedList<Integer> stack2;

        public MyQueue() {
            stack1 = new LinkedList<>(); //入队列--->pop到stack2
            stack2 = new LinkedList<>(); //出队列--->pop栈顶元素就是第一个进入stack1的
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop()); //进入stack2
                }
            }
            return stack2.pop(); //弹出栈顶元素【第一次进入stack1的那个】
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
