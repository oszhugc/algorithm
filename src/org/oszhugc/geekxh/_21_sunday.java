package org.oszhugc.geekxh;

/**
 * 实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 *
 */
public class _21_sunday {

    /**     * sunday采用模式匹配的思想， 匹配失败时， 选择haystack中参加匹配的最末尾字符的后一位字符作为参照字符，
     * 如果该字符在needle串中串， 则将needle串中最后出现该字符的位置与参照字符位置对其继续比较，否则直接跳过该匹配区域
     * 从参照字符的下一个位置重新开始比较。
     *
     * @param haystack
     * @param needle
     * @return
     */
   public static int sunday(String haystack, String needle){
       int hayLen = haystack.length();
       int nLen = needle.length();
       //haystack串的游标索引
       int i = 0;
       //needle串的游标索引
       int j = 0;
       //haystack剩余字符小于needle串时跳出比较
       while (i <= hayLen - nLen){
           //将needle串与haystack串中参与比较的子串进行逐个字符比较
           while (j < nLen &&haystack.charAt(i+j) == needle.charAt(j)){
               j++;
           }
           //如果j等于needle串的长度说明此时匹配成功， 可以直接返回此时主串的游标索引
           if (j == nLen){
               return i;
           }
           //不匹配时计算需要跳过的字符串， 移动主串游标
           if (i < hayLen - nLen){
               //对照字符在needle串存在， 则需要跳过的字符数从对照字符在needle串中最后出现的位置起剩余的字符个数
               //不存在则跳过的字符串为needle串长度+1， 也就是代码nLen-(-1)的情况
               i += (nLen - lastIndex(needle, haystack.charAt(i+nLen)));
           }else {
               return -1;
           }
           //每次比较完之后将needle游标置为0
           j = 0;
       }
       return -1;
   }

   public static int lastIndex(String str, char cn){
       //从后往前检索
       for (int j = str.length()-1; j >= 0; j--){
           if (str.charAt(j) == cn){
               return j;
           }
       }
       return -1;
   }
}
