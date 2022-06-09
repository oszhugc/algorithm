package org.oszhugc.geekxh;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 则自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class _17_minimumTotal {

    /**
     * 寻找最优解的问题， 通常可以转化为动态规划问题
     * 设f(i,j)为走到（i,j）处时的最小 路径和， 则转移方程为：
     *  f(i-1,j) + triangle(i,j) j=0
     *  Min(f(i-1,j-1), f(i-1,j)+triangle(i,j)) 0<j<i
     *  f(i-1,j-1)+triangle(i,j)
     *
     * @param triangle
     * @return
     */
    public static int minTotal(List<List<Integer>> triangle){
        //特殊值判断
        int row = triangle.size();
        if (row == 0){
            return 0;
        }
        //建立n*n的动态规划数组并初始化
        int[][] dp = new int[row][row];
        dp[0][0] = triangle.get(0).get(0);
        //通过转移方程填满动态规划数组
        for (int r = 1; r < row; r++) {
            for (int c = 0; c <= r; c++){
                int f1 = c > 0 ? dp[r-1][c-1] : Integer.MAX_VALUE;
                int f2 = c < r ? dp[r-1][c] : Integer.MAX_VALUE;
                dp[r][c] = Math.min(f1, f2) + triangle.get(r).get(c);
            }
        }
        //找到最后一行的最小值
        int min = Integer.MAX_VALUE;
        for (int num : dp[row - 1]) {
            min = Math.min(num, min);
        }
        return min;
    }

    /**
     * 在上面的基础上进行空间优化。 由于每一行的结果只与上一行有关， 所以可以将n*n的动态规划数组简化为
     * 两个长度为n的一维数组， 根据行号的奇偶性交替更新
     *
     * @param triangle
     * @return
     */
    public static int minTotal2(List<List<Integer>> triangle){
        //特殊值处理
        int row = triangle.size();
        if (row == 0){
            return 0;
        }
        //2*n的动态规划数组
        int[][] dp = new int[2][row];
        dp[0][0] = triangle.get(0).get(0);
        for (int r = 1; r < row; r++){
            for (int c = 0; c <= r; c++){
                //当前行号
                int curRow = r % 2;
                int f1 = c > 0 ? dp[1-curRow][c-1] : Integer.MAX_VALUE;
                int f2 = c < r ? dp[1-curRow][c] : Integer.MAX_VALUE;
                dp[curRow][c] = Math.min(f1, f2) + triangle.get(r).get(c);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[1 - row % 2]) {
            min = Math.min(min, num);
        }
        return min;
    }



}
