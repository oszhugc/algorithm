package org.oszhugc.geekxh;

/**
 *  最长公共前缀
 *
 *  输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class _02_longestCommonPrefix {


    public static String longestCommonPrefix(String[] strings){
       if (strings == null || strings.length == 0){
           return "";
       }
       String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            prefix = longestCommonPrefix(prefix, strings[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix(String prefix, String string) {
        int length = Math.min(prefix.length(), string.length());
        int index = 0;
        while (index < length &&prefix.charAt(index) == string.charAt(index)){
            index++;
        }
        return prefix.substring(0, index);
    }


}
