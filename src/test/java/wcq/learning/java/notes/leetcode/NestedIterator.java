package wcq.learning.java.notes.leetcode;

import java.util.*;

/**
 * 题目：扁平化嵌套列表迭代器
 *
 * @author: wengchuqin
 * @create: 2020-03-21 22:32
 */
public class NestedIterator implements Iterator<Integer> {

    private final Stack<Integer> data;


    public NestedIterator(List<NestedInteger> nestedList) {
        data = new Stack<>();
        dfs(nestedList);
        Collections.reverse(data);
    }

    private void dfs(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }

        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                data.push(n.getInteger());
            } else {
                dfs(n.getList());
            }
        }
    }


    @Override
    public Integer next() {
        return data.pop();
    }

    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }


    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static private class Int implements NestedInteger {
        final int n;

        public Int(int n) {
            this.n = n;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return n;
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }

    static private class IntArr implements NestedInteger {
        final List<NestedInteger> intArr;

        public IntArr(List<NestedInteger> intArr) {
            this.intArr = intArr;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return intArr;
        }
    }

    public static void main(String[] args) {
        NestedIterator nestedIterator = new NestedIterator(Arrays.asList(
                new Int(9),
                new Int(0),
                new IntArr(
                        Arrays.asList(new Int(10), new Int(11), new IntArr(Arrays.asList(new Int(5), new Int(6))))
                )
        ));
        System.out.println(nestedIterator.data);

        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }

        System.out.println(new NestedIterator(null));
        System.out.println(new NestedIterator(new ArrayList<>()));
    }

}

