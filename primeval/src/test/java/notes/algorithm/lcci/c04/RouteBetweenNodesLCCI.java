package notes.algorithm.lcci.c04;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 题目：节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-04-11 15:36
 */
public class RouteBetweenNodesLCCI {
    @Test
    public void test() {
        Solution s = new Solution();
        int n = 3;
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        Solution.Graph g = s.new Graph(n, graph);
        System.out.println(g);
    }


    @Test
    public void test2() {
        Solution s = new Solution();
        int n = 3;
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        int start = 0;
        int target = 2;
        Assert.assertTrue(s.findWhetherExistsPath(n, graph, start, target));
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int n = 5;
        int[][] graph = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        int start = 0;
        int target = 4;
        Assert.assertTrue(s.findWhetherExistsPath(n, graph, start, target));
    }


    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            return new DFS(new Graph(n, graph), start, target).findWhetherExistsPath();
        }

        class DFS {
            Graph g;
            int start;
            int target;
            Set<Integer> visitSet;

            public DFS(Graph g, int start, int target) {
                this.g = g;
                this.start = start;
                this.target = target;
                this.visitSet = new HashSet<>();
            }

            boolean findWhetherExistsPath() {
                return dfs(start, target);
            }

            boolean dfs(int start, int target) {
                if (start == target) {
                    return true;
                }

                visist(start);
//                System.out.println("visit:" + start);

                for (int next : g.nodes[start]) {
                    if (isVisist(next)) {
                        continue;
                    }

                    if (dfs(next, target)) {
                        return true;
                    }
                }

                return false;
            }


            void visist(int node) {
                visitSet.add(node);
            }


            boolean isVisist(int node) {
                return visitSet.contains(node);
            }


        }

        class Graph {
            final Integer[][] nodes;

            public Graph(int n, int[][] graph) {
                List<LinkedHashSet<Integer>> tmp;
                tmp = new ArrayList<>();
                IntStream.range(0, n).forEach(i -> tmp.add(new LinkedHashSet<>()));

                for (int i = 0; i < graph.length; i++) {
                    tmp.get(graph[i][0]).add(graph[i][1]);
                }

                nodes = tmp.stream()
                        .map(s -> s.toArray(new Integer[0]))
                        .toArray(Integer[][]::new);

            }

            @Override
            public String toString() {
                return "Graph{" +
                        "nodes=" + nodes +
                        '}';
            }

        }

    }
}
