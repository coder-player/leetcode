package com.fqh.week_race.week_313;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/6 19:14:00
 */

/**
 * 3.最小 XOR
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
 *
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 *
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 *
 * 整数的 置位数 是其二进制表示中 1 的数目
 * 输入：num1 = 3, num2 = 5
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0011 和 0101 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 3 = 0 是最小的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimize-xor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Question3 {

    public static void main(String[] args) {
        System.out.println(new Question3().minimizeXor(1, 12));
    }

    // 位运算
    public int minimizeXor(int num1, int num2) {
        // num2二进制中 1的个数
        int c2 = Integer.bitCount(num2);
        // 如果c2 > num1二进制的长度
        if (c2 >= Integer.toBinaryString(num1).length()) {
            return (1 << c2) - 1;
        }
        int c1 = Integer.bitCount(num1);
        // 去掉1 等价于去掉 num1 最低的c1 - c2个1 （lowbit)
        // x的lowbit
        // x & -x
        // x -= x & -x
        // x &= x - 1
        while (c2 < c1) {
            num1 &= num1 - 1; // 去掉 lowbit
            c2 += 1;
        }
        // c2 > c1 去掉 num1 最低的c2 -c1 个0
        // y = -x
        // x |= y & -y
        // x |= x + 1
        while (c2 > c1) {
            num1 |= num1 + 1;
            c2 += 1;
        }
        return num1;
    }
}
