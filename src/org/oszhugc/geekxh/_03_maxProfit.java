package org.oszhugc.geekxh;


/**
 * 难度：中等
 * 题目描述：给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 */
public class _03_maxProfit {

    public static int maxProfit(int[] prices){
        if (prices == null || prices.length <= 1) return 0;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                ans += (prices[i] - prices[i-1]);
            }
        }
        return ans;
    }

    public static int maxProfit2(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
            System.out.println(dp[i][0] + " " + dp[i][1]);
        }
        return dp[prices.length-1][-0];
    }

}
