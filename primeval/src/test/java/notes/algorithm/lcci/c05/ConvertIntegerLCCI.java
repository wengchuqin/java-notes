package notes.algorithm.lcci.c05;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Integer.toBinaryString;

/**
 * 题目：整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 *
 * @author: wengchuqin
 * @create: 2020-05-07 22:33
 */
public class ConvertIntegerLCCI {
    @Test
    public void test() {
        Assert.assertEquals(2, new Solution().convertInteger(1, 2));
    }

    class Solution {
        public int convertInteger(int A, int B) {
            //将A、B进行异或运行，不一致的位值为1.
            int result = A ^ B;
            System.out.printf("A:%s, B:%s, result:%s\n", toBinaryString(A), toBinaryString(B), toBinaryString(result));
            //计算值为1的位的数量
            return Integer.bitCount(result);
        }


    }


}
