package org.oszhugc.geekxh;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class _16_lengthOfLIS {


    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18, 102, 1, 2, 3, 4};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS_2(nums));
    }


    /**
     * 1.定义状态： 由于一个子序列一定会以一个数结尾， 于是将状态定义成 dp[i]表示以nums[i]结尾的上升子序列的长度
     * 2.考虑状态转移方程：
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * (X)错误求解
     * dp[i] = nums[i] > nums[i-1] ? dp[i-1]+1 : dp[i-1]
     * @param nums
     * @return
     */
    public static int lengthOfLIS_2(int[] nums){
        int len = nums.length;
        if (len < 2){
            return len;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = nums[i] > nums[i-1] ? dp[i-1]+1 : dp[i-1];
        }
        return dp[len-1];
    }
}
