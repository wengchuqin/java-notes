package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 题目：设计循环双端队列  https://leetcode-cn.com/problems/design-circular-deque/
 * @author: wengchuqin
 * @create: 2020-03-24 23:08
 */
public class DesignCircularDeque {


    @Test
    public void test() {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertLast(1);                    // 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        Assert.assertFalse(circularDeque.insertFront(4)); // 已经满了，返回 false
        Assert.assertEquals(2, circularDeque.getRear());
        Assert.assertTrue(circularDeque.isFull());
        Assert.assertTrue(circularDeque.deleteLast());
        circularDeque.insertFront(4);                    // 返回 true
        Assert.assertEquals(4, circularDeque.getFront());
    }

    @Test
    public void test2() {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        Assert.assertTrue(circularDeque.insertFront(9));
        Assert.assertEquals(9, circularDeque.getRear());
    }

    @Test
    public void test3() {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        Assert.assertTrue(circularDeque.isEmpty());
        Assert.assertFalse(circularDeque.deleteLast());
    }


    /**
     * 设计 head 和 tail 指针变量。
     * (1) ((head + 1) % capacity) == tail 表示队列为空  （2）head == tail 表示队列满了
     */
    class MyCircularDeque {
        private final int capacity;
        private final int[] queueValue;
        private int head;
        private int tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.capacity = k + 1;
            this.queueValue = new int[this.capacity];
            this.head = 0;
            this.tail = 1;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            queueValue[head] = value;
            head = (head - 1 + capacity) % capacity;

            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            queueValue[tail] = value;
            tail = (tail + 1 + capacity) % capacity;

            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            head = (head + 1 + capacity) % capacity;

            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            tail = (tail - 1 + capacity) % capacity;

            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            return queueValue[(head + 1 + capacity) % capacity];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return queueValue[(tail - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return ((head + 1) % capacity) == tail;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return head == tail;
        }
    }
}
