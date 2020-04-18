package notes.algorithm.lcci.c08;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：迷路的机器人 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 题解：使用回溯法，遍历所有路径
 *
 * @author: wengchuqin
 * @create: 2020-04-11 19:05
 */
public class RobotInAGridLCCI {
    @Test
    public void test0() {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(new Solution().pathWithObstacles(grid));
    }

    @Test
    public void test() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new Solution().pathWithObstacles(grid));
    }

    @Test
    public void test2() {
        int[][] grid = {
                {0, 0, 0}
        };
        System.out.println(new Solution().pathWithObstacles(grid));
    }

    @Test
    public void test3() {
        int[][] grid = {
                {1}
        };
        System.out.println(new Solution().pathWithObstacles(grid));
    }

    class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            return new Helper(obstacleGrid).pathWithObstacles();
        }

        class Helper {
            int[][] obstacleGrid;
            Set<Point> visitSet;

            public Helper(int[][] obstacleGrid) {
                this.obstacleGrid = obstacleGrid;
                this.visitSet = new HashSet<>();
            }

            public List<List<Integer>> pathWithObstacles() {
                LinkedList<Point> path = new LinkedList<>();
                path.addLast(new Point(0, 0));
                boolean found = dfs(path, new Point(obstacleGrid.length - 1, obstacleGrid[0].length - 1));
                return found ? format(path) : new ArrayList<>();
            }

            private List<List<Integer>> format(LinkedList<Point> path) {
                return path.stream().map(p -> Arrays.asList(p.x, p.y)).collect(Collectors.toList());
            }

            public boolean dfs(LinkedList<Point> path, Point target) {
                if (path.isEmpty()) {
                    return false;
                }

                Point cur = path.getLast();
                visitSet.add(cur);
                if (!check(cur)) {
                    return false;
                }
                if (Objects.equals(cur, target)) {
                    return true;
                }

                //回溯法，遍历所有路径
                for (Point next : next(cur)) {
                    if (visitSet.contains(next)) {
                        continue;
                    }
                    path.addLast(next);
                    if (dfs(path, target)) {
                        return true;
                    }
                    path.removeLast();
                }

                return false;
            }


            public boolean check(Point p) {
                if (!(p.x >= 0 && p.x < obstacleGrid.length)) {
                    return false;
                } else if (!(p.y >= 0 && p.y < obstacleGrid[p.x].length)) {
                    return false;
                } else if (obstacleGrid[p.x][p.y] == 1) {
                    return false;
                } else {
                    return true;
                }
            }

            public List<Point> next(Point p) {
                return Arrays.asList(
                        new Point(p.x + 1, p.y),
                        new Point(p.x, p.y + 1)
                );
            }
        }

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
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

            @Override
            public String toString() {
                return String.format("{%s, %s}", x, y);
            }
        }
    }
}
