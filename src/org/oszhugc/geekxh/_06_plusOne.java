package org.oszhugc.geekxh;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class _06_plusOne {

    /**
     * 从后向前遍历数组， 如果遇到的数字不是9， 则加一并返回数组；
     * 如果是9， 则当前位赋值为0， 继续向前进行循环到前一位， 如果不是9， 则加一返回；
     * 一直往复， 直到遍历全部数组元素；
     * 当数组元素全部为9， 则新建一个长度比原来数组大一个长度的数组 ， 第一位赋值1， 其他位0
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits){
       for (int i = digits.length -1; i >= 0; i--){
           if (digits[i] != 9){
               //如果不是9直接加一返回
               digits[i]++;
               return digits;
           }
           //当前位是9， 需要进位
           digits[i] = 0;
       }
       //跳出for循环说明数字全部是9
        int[] result = new int[digits.length + 1];
       result[0] = 1;
       return result;
    }
}
