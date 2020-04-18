package notes.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: wengchuqin
 * @create: 2020-03-29 13:39
 */
public class AsFarFromLandAsPossible {

    @Test
    public void test0() {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Solution solution = new Solution();
        Assert.assertEquals(2, solution.maxDistance(grid));
    }

    @Test
    public void test1() {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Solution solution = new Solution();
        Solution.Point start = solution.new Point(1, 1);
        Solution.BfsHelper helper = solution.new BfsHelper(grid, start);
        Assert.assertEquals(2, helper.findNearestLand());
    }


    @Test
    public void test2() {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Solution solution = new Solution();
        Solution.Point start = solution.new Point(0, 1);
        Solution.BfsHelper helper = solution.new BfsHelper(grid, start);
        Assert.assertEquals(1, helper.findNearestLand());
    }

    @Test
    public void test3() {
        int[][] grid = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Solution solution = new Solution();
        Solution.Point start = solution.new Point(0, 0);
        Solution.BfsHelper helper = solution.new BfsHelper(grid, start);
        Assert.assertEquals(-1, helper.findNearestLand());
    }


    @Test
    public void test4() {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        Solution solution = new Solution();
        Solution.Point start = solution.new Point(0, 0);
        Solution.BfsHelper helper = solution.new BfsHelper(grid, start);
        Assert.assertEquals(-1, helper.findNearestLand());
    }


    @Test
    public void test5() {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };

        Solution solution = new Solution();
        Solution.Point start = solution.new Point(0, 0);
        Solution.BfsHelper helper = solution.new BfsHelper(grid, start);
        Assert.assertEquals(-1, helper.findNearestLand());
    }


    class Solution {
        public int maxDistance(int[][] grid) {
            int max = -1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int nearestLand = new BfsHelper(grid, new Point(i, j)).findNearestLand();
                    max = Math.max(max, nearestLand);
                }
            }
            return max;
        }


        public class BfsHelper {
            final Map map;
            final Point startingPoint;
            final Set<Point> recordSet;


            public BfsHelper(int[][] grid, Point startingPoint) {
                this.map = new Map(grid);
                this.startingPoint = startingPoint;
                this.recordSet = new HashSet<>();
            }

            public int findNearestLand() {
                if (map.isLand(startingPoint)) {
                    return -1;
                }

                return bfs(startingPoint);
            }

            private int bfs(Point p) {
//                System.out.println(p);
                if (map.isOutOfBounds(p)) {
//                    System.out.println("超出范围, " + p);
                    return -1;
                }
                if (recordSet.contains(p)) {
                    return -1;
                }

                recordSet.add(p);
                if (map.isLand(p)) {
                    return startingPoint.distance(p);
                }

                int d1 = bfs(p.up());
                int d2 = bfs(p.down());
                int d3 = bfs(p.left());
                int d4 = bfs(p.right());

                return findMin(findMin(d1, d2), findMin(d3, d4));
            }

            /**
             * -1表示空。
             *
             * @param d1
             * @param d2
             * @return
             */
            private int findMin(int d1, int d2) {
                if (d1 == -1 && d2 == -1) {
                    return -1;
                }

                if (d1 == -1) {
                    d1 = Integer.MAX_VALUE;
                }

                if (d2 == -1) {
                    d2 = Integer.MAX_VALUE;
                }

                return Math.min(d1, d2);
            }
        }

        public class Map {
            final int[][] grid;

            public Map(int[][] grid) {
                this.grid = grid;
            }

            public boolean isLand(Point p) {
                return grid[p.x][p.y] == 1;
            }

            public boolean isWater(Point p) {
                return !isLand(p);
            }

            public boolean isOutOfBounds(Point p) {
                return p.x < 0 || p.y < 0 || p.x >= grid.length || p.y >= grid[0].length;
            }
        }

        public class Point {
            final int x;
            final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return String.format("(%s, %s)", x, y);
            }

            public int distance(Point otherPoint) {
                return Math.abs((this.x - otherPoint.x)) + Math.abs((this.y - otherPoint.y));
            }

            public Point left() {
                return new Point(this.x, this.y - 1);
            }

            public Point right() {
                return new Point(this.x, this.y + 1);
            }

            public Point up() {
                return new Point(this.x - 1, this.y);
            }

            public Point down() {
                return new Point(this.x + 1, this.y);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}
