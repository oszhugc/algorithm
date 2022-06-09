package org.oszhugc.geekxh;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *
 * 输出: [2,2]
 */
public class _01_intersect {

    public static int[] intersect(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                resSet.add(nums2[i]);
            }
        }
        int[] res = new int[resSet.size()];
        int k = 0;
        for (Integer v : resSet) {
            res[k++] = v;
        }
        return res;
    }
}
