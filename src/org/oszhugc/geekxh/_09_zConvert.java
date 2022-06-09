package org.oszhugc.geekxh;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 *
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class _09_zConvert {

    /**
     * 整体的思路时遍历字符串，遍历过程中将每行都看成新的字符串构成的字符串数组， 最后再将该数组拼接起来即可。
     * 如果numRows=1则说明当前字符串即为结果， 直接返回
     * 否则整个字符串需要经历， 向下向右， 向下向右...这样的反复循环过程
     * 设定down变量表示是否向下， loc变量表示当前字符串数组的下标， 如果down为true, 则loc+=1, 字符串数组下标向后移动， 将当前字符加入当前字符串中
     * 如果down为false, 则表示向右， 则loc-=1, 字符串数组下标向前移动， 将当前字符加入当前字符串中
     * 时间复杂度O(n)，n为字符串s的长度
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String zConvert(String s, int numRows){
        //判断要输出的行数， 如果为一行则直接返回本字符串
        if (numRows == 1){
            return s;
        }
        //如果字符串长度过段， 则输出的行数有可能达不到预期的行数， 所以这里采用字符串长度和
        int len = Math.min(s.length(), numRows);
        //创建字符串型的数组
        String[] rows = new String[len];
        //通过循环， 将数组初始化
        for (int i = 0; i < len; i++) {
            rows[i] = "";
        }
        //loc代表数组的下标
        int loc = 0;
        //down表示是否向下走
        boolean down = false;
        //遍历字符串， 并将元素添加进制定的位置
        for (int i = 0; i < s.length(); i++) {
            rows[loc] += s.substring(i, i+1);
            //判断loc==0是否在第一行， loc==numRows-1判断是否在最后一行
            if (loc == 0 || loc == numRows -1){
                //翻转方向
                down = !down;
            }
            //通过down的值来改变你loc
            loc += down ? 1 : -1;
        }
        //字符串拼接
        String ans = "";
        for (String row : rows) {
            ans += row;
        }
        return ans;
    }


}
