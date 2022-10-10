package com.fqh.codetop;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 海盗狗
 * @version 1.0
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_09 {

    public static void main(String[] args) {

        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {
        //使用LinkedList效率较快, Stack底层是Vector
        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value); //直接将值push进s1
        }

        public int deleteHead() {
            while (!stack1.isEmpty()) { //将s1的元素弹出并加入s2
                stack2.push(stack1.pop());
            }
            return stack2.pop(); //弹出s2的栈顶元素, 造成FIFO的假象
        }
    }
}
