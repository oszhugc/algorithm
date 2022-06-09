package org.oszhugc.geekxh;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。
 *  你有多少种不同的方法可以爬到楼顶呢？
 *  **注意：**给定 n 是一个正整数。
 *
 *  输入： 3   输出： 3  解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class _14_climbStairs {

    /**
     * dp[n] = dp[n-1] + dp[n-2]
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
