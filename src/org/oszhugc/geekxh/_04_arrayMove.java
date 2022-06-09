package org.oszhugc.geekxh;


import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 */
public class _04_arrayMove {

    public static void arrayMove(int[] arr, int k){
        int len = arr.length;
        k = k % len;
        int temp = 0;
        for (int i = 0; i < len/2; i++) {
            temp = arr[len-1-i];
            arr[len-1-i]=arr[i];
            arr[i]=temp;
        }
        for (int i = 0; i < k/2; i++) {
            temp = arr[k-1];
            arr[k-1]=arr[i];
            arr[i]=temp;
        }
        for (int i = k, j=len-1; i < j; i++,  j--){
            temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }

        System.out.println("数组向后移动k位的结果为： " + Arrays.toString(arr));
    }
}
