package org.oszhugc.geekxh;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 */
public class _20_reverseString {


    /**
     * 定义left和right分别指向首元素和尾元素
     * 当left < right ，进行交换。
     * 交换完毕，left++，right--
     * 直至left == right
     *
     * @param s
     */
    public static void reverseString(char[] s){
        int left = 0, right = s.length-1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
