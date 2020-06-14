package notes.algorithm.lcci.c08;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 题目：
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * https://leetcode-cn.com/problems/bracket-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-06-14 20:21
 */
public class BracketLCCI {

    @Test
    public void test() {
        List<String> result = new Solution().generateParenthesis(3);
        result.stream().forEach(System.out::println);
    }

    /**
     * 遍历所有可能
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            return new Help(n).traversal().result();
        }

        class Help {
            int n;
            Set<State> result;

            public Help(int n) {
                this.n = n;
                this.result = new LinkedHashSet<>();
            }

            public Help traversal() {
                traversal(new State());
                return this;
            }

            public List<String> result() {
                return result.stream().map(o -> o.parentheses.toString()).collect(Collectors.toList());
            }

            private void traversal(State state) {
//                System.out.println("traversal start... " + state);

                //n对括号了，停止循环
                if (state.ln == n && state.rn == n) {
                    result.add(state);
                    return;
                }

                //考虑加左括号
                if (state.ln < n) {
                    State next = state.clone();
                    next.left();
                    traversal(next);
                }

                //考虑加右括号
                if (state.rn < n && state.ln > state.rn) {
                    State next = state.clone();
                    next.right();
                    traversal(next);
                }
            }
        }

        class State {
            int ln;
            int rn;
            StringBuilder parentheses;


            public State() {
                ln = 0;
                rn = 0;
                parentheses = new StringBuilder();
            }

            public State(int ln, int rn, StringBuilder parentheses) {
                this.ln = ln;
                this.rn = rn;
                this.parentheses = parentheses;
            }

            public void left() {
                ln++;
                parentheses.append("(");
            }


            public void right() {
                rn++;
                parentheses.append(")");
            }


            @Override
            protected State clone() {
                return new State(this.ln, this.rn, new StringBuilder(this.parentheses));
            }

            @Override
            public String toString() {
                return "State{" +
                        "ln=" + ln +
                        ", rn=" + rn +
                        ", parentheses=" + parentheses +
                        '}';
            }
        }
    }
}
