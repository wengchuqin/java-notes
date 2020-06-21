package notes.algorithm.pack.q1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wengchuqin
 * @create: 2020-06-21 22:38
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 读入数据的代码
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1];
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close();

        // 正式工作的代码
        System.out.println(solution(N, V, v, w));
    }

    /**
     * @param N 物品的数量为N
     * @param V 背包的容量为V
     * @param v 第i个元素表示第i个物品的体积
     * @param w 第i个元素表示第i个物品的价值
     * @return
     */
     /*
        定义一个二阶矩阵dp[N+1][V+1],
        这里之所以要N+1和V+1，是因为第0行表示只能选择第0个物品的时候，即没有物品的时候
        第0列表示背包的体积为0的时候，即不能装任何东西的时候

        dp[i][j]表示在 只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
        对于dp[i][j]有两种情况：
        1. 不选择当前的第i件物品/第i件物品比背包容量要大，则dp[i][j] = dp[i-1][j]
        2. 选择当前的第i件物品（潜在要求第i件物品体积小于等于背包总容量），则能装入的物品最大价值为：
            当前物品的价值 加上 背包剩余容量在只能选前i-1件物品的情况下的最大价值
            dp[i][j] = dp[i-1][j-v[i]] + w[i]
        dp[i][j]在两种情况中选择比较大的情况作为当前的最优解；
        即：
        if(j >= v[i]):
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
        else:
            dp[i][j] = dp[i-1][j]
       */
    private static int solution(int N, int V, int[] v, int[] w) {
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        Arrays.stream(dp).forEach(t -> System.out.println(Arrays.toString(t)));
        return dp[N][V];
    }

    @Test
    public void test() {
        int N = 4; //物品数量
        int MAX_V = 5; //容积
        int[] v = new int[]{0, 1, 2, 3, 4};  //体积
        int[] w = new int[]{0, 2, 4, 4, 5};  //价值
        Assert.assertEquals(8, solution(N, MAX_V, v, w));
    }
}
