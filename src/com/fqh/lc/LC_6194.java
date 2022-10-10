package com.fqh.lc;

/**
 * @author The End of Death
 * @version 1.0
 * @since 2022/10/2 11:22:54
 */
public class LC_6194 {

    public static void main(String[] args) {

        System.out.println(new LC_6194().minimizeXor(3, 5));
    }

    //N-AC
    public int minimizeXor(int num1, int num2) {
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        System.out.println(s1);
        System.out.println(s2);
        return 1;
    }

}
