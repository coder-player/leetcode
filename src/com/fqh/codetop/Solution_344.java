package com.fqh.codetop;

/**
 * @author 我劝你荔枝_FQH
 * @version 1.0
 * Date: 2022/6/5 23:10:30
 * 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class Solution_344 {

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    //双指针 + 临时temp变量
    public static void reverseString(char[] s) {

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

    }
}
