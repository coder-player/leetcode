package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/1 23:16:27
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 */
public class Solution_125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    //双指针
    public static boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        StringBuilder template = new StringBuilder();
        //将s组装成完整的字符串
        for (char c : lowerCase.toCharArray()) {
            int range = c + 0;
            if (range >= 65 && range <= 90) {
                template.append(c);
            }
            if (range >= 97 && range <= 122) {
                template.append(c);
            }
            if (range >= 48 && range <= 57) {
                template.append(c);
            }
        }
        //双指针法
        int l = 0;
        int r = template.length() - 1;
        char[] chars = template.toString().toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
