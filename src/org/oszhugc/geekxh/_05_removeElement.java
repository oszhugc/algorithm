package org.oszhugc.geekxh;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class _05_removeElement {

    /**
     * 原地： 移除所有数值等于val的元素， 并且返回移除的长度
     * 需要确定修改
     * 元素顺序可变（可为任意顺序）
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val){
        int newLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[1] != val){
                nums[newLen] = nums[i];
                newLen++;
            }
        }
        return newLen;
    }
}
