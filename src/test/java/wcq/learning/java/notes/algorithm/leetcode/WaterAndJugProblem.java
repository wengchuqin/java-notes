package wcq.learning.java.notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 题目：https://leetcode-cn.com/problems/water-and-jug-problem/
 * <p>
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * &nbsp;&nbsp;装满任意一个水壶
 * &nbsp;&nbsp;清空任意一个水壶
 * &nbsp;&nbsp;从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * <p>
 * 题解参考：https://leetcode-cn.com/problems/water-and-jug-problem/solution/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/
 *
 * @author: wengchuqin
 * @create: 2020-03-21 15:15
 */
public class WaterAndJugProblem {
    private static final Logger logger = LoggerFactory.getLogger(WaterAndJugProblem.class);


    @Test
    public void test1() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canMeasureWater(3, 5, 4));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canMeasureWater(2, 6, 5));
    }


    @Test
    public void test3() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canMeasureWater(2, 6, 9));
    }


    @Test
    public void test4() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canMeasureWater(2, 6, 0));
    }


    private static class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            return new JugOperateHelper(x, y, z).canMeasureWater();
        }


        private static class JugOperateHelper {
            final int jugACapacity;
            final int jugBCapacity;
            final int destRemain;
            final JugStateQueue queue;

            public JugOperateHelper(int jugACapacity, int jugBCapacity, int destRemain) {
                this.jugACapacity = jugACapacity;
                this.jugBCapacity = jugBCapacity;
                this.destRemain = destRemain;
                this.queue = new JugStateQueue();
            }

            public boolean operate(State state, BiConsumer<Jug, Jug> consumer) {
                Jug a = new Jug(jugACapacity, state.jugARemain);
                Jug b = new Jug(jugBCapacity, state.jugBRemain);
                consumer.accept(a, b);
                if (canMeasureWater(a, b, destRemain)) {
//                    logger.info("A:{},  B:{}, destRemain:{}", a, b, destRemain);
                    return true;
                }
                queue.offerIfAbsend(new State(a.remain, b.remain));
                return false;
            }

            public boolean canMeasureWater() {

                queue.offerIfAbsend(new State(0, 0));

                while (!queue.isEmpty()) {
                    State state = queue.poll();


                    //Fill any of the jugs completely with water.
                    if (operate(state, (jugA, jugB) -> jugA.fill())) {
                        return true;
                    }

                    if (operate(state, (jugA, jugB) -> jugB.fill())) {
                        return true;
                    }


                    //Empty any of the jugs.
                    if (operate(state, (jugA, jugB) -> jugA.empty())) {
                        return true;
                    }

                    if (operate(state, (jugA, jugB) -> jugB.empty())) {
                        return true;
                    }


                    //Pour water from one jug into another till the other jug is completely full or the head jug itself is empty.
                    if (operate(state, (jugA, jugB) -> jugA.pourInto(jugB))) {
                        return true;
                    }

                    if (operate(state, (jugA, jugB) -> jugB.pourInto(jugA))) {
                        return true;
                    }


                }

                return false;
            }

            public boolean canMeasureWater(Jug a, Jug b, int z) {
                return a.remain + b.remain == z;
            }

        }


        private static class JugStateQueue {
            Set<State> set = new HashSet<>();
            Queue<State> queue = new LinkedList<>();

            void offerIfAbsend(State e) {
                if (set.contains(e)) {
                    return;
                }
                set.add(e);
                queue.offer(e);
            }

            boolean isEmpty() {
                return queue.isEmpty();
            }

            State poll() {
                return queue.poll();
            }
        }

        private static class State {
            public final int jugARemain;
            public final int jugBRemain;

            public State(int jugARemain, int jugBRemain) {
                this.jugARemain = jugARemain;
                this.jugBRemain = jugBRemain;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                State state = (State) o;
                return jugARemain == state.jugARemain &&
                        jugBRemain == state.jugBRemain;
            }

            @Override
            public int hashCode() {
                return Objects.hash(jugARemain, jugBRemain);
            }
        }


        private static class Jug {
            public final int capacity;
            public int remain;

            public Jug(int capacity) {
                this.capacity = capacity;
                this.remain = 0;
            }

            public Jug(int capacity, int remain) {
                this.capacity = capacity;
                this.remain = remain;
            }

            public void fill() {
                this.remain = capacity;
            }

            public void empty() {
                this.remain = 0;
            }


            //Pour water from one jug into another till the other jug is completely full or the head jug itself is empty.
            public void pourInto(Jug another) {
                int tmp = another.capacity - another.remain;
                if (this.remain > tmp) {
                    this.remain -= tmp;
                    another.remain += tmp;
                } else {
                    another.remain += this.remain;
                    this.remain = 0;
                }
            }

            @Override
            public String toString() {
                return "" +
                        "capacity=" + capacity +
                        ", remain=" + remain;
            }
        }

        @Test
        public void JugTest() {
            Jug a = new Jug(3);
            Jug b = new Jug(5);

            a.fill();
            Assert.assertEquals(a.remain, 3);
            Assert.assertEquals(b.remain, 0);

            a.pourInto(b);
            Assert.assertEquals(a.remain, 0);
            Assert.assertEquals(b.remain, 3);

            a.fill();
            Assert.assertEquals(a.remain, 3);
            Assert.assertEquals(b.remain, 3);

            a.pourInto(b);
            Assert.assertEquals(a.remain, 1);
            Assert.assertEquals(b.remain, 5);
        }
    }

}

