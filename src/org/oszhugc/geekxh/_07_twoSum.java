package org.oszhugc.geekxh;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class _07_twoSum {

    /**
     * 通过map的数据结构， 简化查询时间， 时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum) && needNum != i){
                return new int[]{i, map.get(needNum)};
            }
        }
        return new int[]{-1, -1};
    }
}
