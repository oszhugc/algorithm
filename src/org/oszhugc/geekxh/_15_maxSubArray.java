package org.oszhugc.geekxh;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class _15_maxSubArray {

    /**
     * 动态规划
     * 1. dp数组的含义： 以当前下标为结尾的最大连续子序列的和
     * 2. dp数组初始化：dp[0], 即以第一个元素为结尾的，  最大连续子序列的和， 即nums[0]
     * 3. dp递推公式： dp[i], 可以是以上一个结尾的子序列和 + 当前数字，  或者就是当前数字
     *     dp[i] = Math.max(nums[i], nums[i]+dp[i-1])
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
