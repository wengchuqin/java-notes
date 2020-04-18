package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 栈的最小值 题目：https://leetcode-cn.com/problems/min-stack-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-03-23 21:32
 */
public class MinStackLCCI {
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

   @Test
    public void test2() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        Assert.assertEquals(-2, minStack.getMin());
    }


    class MinStack {
        final Stack<Pair> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new Pair(x, x));
                return;
            }

            Pair p = stack.peek();
            if (p.min >= x) {
                stack.push(new Pair(x, x));
            } else {
                stack.push(new Pair(x, p.min));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().min;
        }

        class Pair {
            int value;
            int min;

            public Pair(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }
}
