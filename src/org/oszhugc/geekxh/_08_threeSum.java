package org.oszhugc.geekxh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 *
 */
public class _08_threeSum {

    /**
     * 1. 数组排序
     * 2. 使用for循环定义第一个元素
     * 3. 再使用双指针进行第二，第三元素的遍历
     * 4. 如果结果为0， 添加到结果的集合中去
     * 5. 最后返回结果
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //当nums的所有元素都大于0时， 任意三数之和都不可能为0
            if (nums[i] > 0) return result;
            //当前一个元素和当前前一个元素相同时， 直接跳过， 避免重复执行
            if (i > 0 && nums[i] == nums[i-1]) continue;
            //使用双指针筛选出三元组的后两个元素
            int left = i+1;
            int right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去除与当前指向相同的元素
                    while (right > left && nums[left] == nums[left+1]) left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    //移动指针进行下一次遍历
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
